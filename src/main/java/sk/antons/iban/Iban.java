/*
 * Copyright 2025 Anton Straka
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sk.antons.iban;

import java.math.BigInteger;

/**
 * Iban helper for parsing format by given pattern.
 *
 * @author antons
 */
public class Iban {
    String iban;
    IbanConfig config;

    private Iban(String iban, IbanConfig config) {
        this.iban = iban;
        this.config = config;
        if(this.config == null) throw new IllegalArgumentException("unable to create iban from " + iban);
    }

    /**
     * Create iban for known country. Country is detemined by first two letters.
     * And known country is defined in IbanConfigRepository.
     * @param iban account number ina iban format.
     * @return new instance
     */
    public static Iban instance(String iban) {
        return instance(iban, IbanConfigRepository.parse(iban));
    }

    /**
     * Create iban for any country.
     * @param iban account number ina iban format.
     * @param config account number configuration.
     * @return new instance
     */
    public static Iban instance(String iban, IbanConfig config) {
        if(iban == null) throw new IllegalArgumentException("iban is null");
        if(iban.length() < 4) throw new IllegalArgumentException("malformed iban " + iban);
        int pos = iban.indexOf(' ');
        if(pos >= 0) {
            //strip spaces;
            StringBuilder sb = new StringBuilder();
            int len = iban.length();
            for(int i = 0; i < len; i++) {
                char c = iban.charAt(i);
                if(c == ' ') continue;
                sb.append(c);
            }
            iban = sb.toString();
        }
        return new Iban(iban, config);
    }

    @Override
    public String toString() {
        return iban;
    }

    /**
     * Iban in compact form.
     * @return
     */
    public String iban() { return iban; }

    /**
     * Iban in space separated form. (Creates four character groups)
     * @return
     */
    public String ibanPretty() {
        StringBuilder sb = new StringBuilder();
        int len = iban.length();
        int spacePos = 0;
        for(int i = 0; i < len; i++) {
            if(spacePos == 4) {
                sb.append(' ');
                spacePos = 0;
            }
            char c = iban.charAt(i);
            sb.append(c);
            spacePos++;
        }
        return sb.toString();
    }

    /**
     * Check if this iban has correct length. (length ja defined in config)
     * @return true if length is correct
     */
    public boolean lengthCheck() {
        return iban.length() == config.length();
    }

    /**
     * Check if this iban has correct format. (format ja defined in config)
     * @return true if format is correct
     */
    public boolean formatCheck() {
        return config.formatCheck(iban);
    }

    /**
     * Check if this iban has correct IBAN checksum digits.
     * @return true if iban cheksum is correct
     */
    public boolean ibanCheck() {
        return ibanCheck(iban);
    }

    /**
     * Check if given iban has correct IBAN checksum digits.
     * @param iban given iban
     * @return true if iban cheksum is correct
     */
    public static boolean ibanCheck(String iban) {
        if(iban == null) return false;
        if(iban.length() < 4) return false;
        StringBuilder sb = new StringBuilder();
        int len = iban.length();
        for(int i = 4; i < len; i++) {
            char c = iban.charAt(i);
            addIbanCharAsNumber(sb, c);
        }
        for(int i = 0; i < 4; i++) {
            char c = iban.charAt(i);
            addIbanCharAsNumber(sb, c);
        }
        BigInteger bi = new BigInteger(sb.toString());
        BigInteger mod = bi.mod(BigInteger.valueOf(97));
        return mod.intValue() == 1;
    }

    /**
     * Returns same given iban with fiched checksum digits.
     * @param iban iban to be fixed
     * @return fixed iban.
     */
    public static String ibanFix(String iban) {
        if(iban == null) return null;
        if(iban.length() < 4) return null;
        StringBuilder sb = new StringBuilder();
        int len = iban.length();
        for(int i = 4; i < len; i++) {
            char c = iban.charAt(i);
            addIbanCharAsNumber(sb, c);
        }
        for(int i = 0; i < 2; i++) {
            char c = iban.charAt(i);
            addIbanCharAsNumber(sb, c);
        }
        sb.append("00");
        BigInteger bi = new BigInteger(sb.toString());
        BigInteger mod = bi.mod(BigInteger.valueOf(97));
        int modi = mod.intValue();
        int checksum = 98 - modi;
        if(checksum < 10) return iban.substring(0, 2) + "0" + checksum + iban.substring(4);
        else return iban.substring(0, 2) + checksum + iban.substring(4);
    }

    private static void addIbanCharAsNumber(StringBuilder sb, char c) {
        if(('0'<= c) && (c <= '9')) {
            sb.append(c);
        } else {
            sb.append(c-'A'+10);
        }
    }

    /**
     * Pattern defined in config.
     * @return pattern
     */
    public String pattern() { return config.pattern; }

    /**
     * format defined in config
     * @return format
     */
    public String format() { return config.format(); }

    /**
     * Finds part of iban defined in pattern by character 'c'.
     * @return selected iban part or null if it is not exists
     */
    public String accountNumber() { return config.resolver('c').resolve(iban); }
    /**
     * Finds part of iban defined in pattern by character 'p'.
     * @return selected iban part or null if it is not exists
     */
    public String accountNumberPrefix() { return config.resolver('p').resolve(iban); }
    /**
     * Finds part of iban defined in pattern by character 'b'.
     * @return selected iban part or null if it is not exists
     */
    public String nationalBankNumber() { return config.resolver('b').resolve(iban); }
    /**
     * Finds part of iban defined in pattern by character 'q'.
     * @return selected iban part or null if it is not exists
     */
    public String bic() { return config.resolver('q').resolve(iban); }
    /**
     * Finds part of iban defined in pattern by character 'm'.
     * @return selected iban part or null if it is not exists
     */
    public String currency() { return config.resolver('m').resolve(iban); }
    /**
     * Finds part of iban defined in pattern by character 's'.
     * @return selected iban part or null if it is not exists
     */
    public String branch() { return config.resolver('s').resolve(iban); }
    /**
     * Finds part of iban defined in pattern by character 't'.
     * @return selected iban part or null if it is not exists
     */
    public String accountType() { return config.resolver('t').resolve(iban); }
    /**
     * Finds part of iban defined in pattern by character 'x'.
     * @return selected iban part or null if it is not exists
     */
    public String checkDigits() { return config.resolver('x').resolve(iban); }
    /**
     * Finds part of iban defined in pattern by given character.
     * @param c given character
     * @return selected iban part or null if it is not exists
     */
    public String patternPart(char c) { return config.resolver(c).resolve(iban); }

    public static void main(String[] argv) {
        Iban iban = Iban.instance("SK17 0900 0000 0000 2404 1632");
        System.out.println(" iban: " + iban.iban());
        System.out.println(" iban pretty : " + iban.ibanPretty());
        System.out.println(" iban pattern : " + iban.pattern());
        System.out.println(" iban format : " + iban.format());
        System.out.println(" iban check length : " + iban.lengthCheck());
        System.out.println(" iban check format : " + iban.formatCheck());
        System.out.println(" iban check iban : " + iban.ibanCheck());
        System.out.println(" iban accountNumber : " + iban.accountNumber());
        System.out.println(" iban accountNumberPrefix : " + iban.accountNumberPrefix());
        System.out.println(" iban nationalBankNumber : " + iban.nationalBankNumber());
        System.out.println(" iban bic : " + iban.bic());
        System.out.println(" iban currency : " + iban.currency());
        System.out.println(" iban branch : " + iban.branch());
        System.out.println(" iban accountType : " + iban.accountType());
        System.out.println(" iban checkDigits : " + iban.checkDigits());
        System.out.println(" iban patternPart : " + iban.patternPart('b'));
        String ib = "SK1709000000000024041632";
        String ibf = ibanFix(ib);
        System.out.println(" iban "+ib+" check : " + iban.ibanCheck(ib));
        System.out.println(" iban "+ibf+" check : " + iban.ibanCheck(ibf));
        ib = "SK1509000000000024041632";
        ibf = ibanFix(ib);
        System.out.println(" iban "+ib+" check : " + iban.ibanCheck(ib));
        System.out.println(" iban "+ibf+" check : " + iban.ibanCheck(ibf));
        ib = "SK7509000000000024041632";
        ibf = ibanFix(ib);
        System.out.println(" iban "+ib+" check : " + iban.ibanCheck(ib));
        System.out.println(" iban "+ibf+" check : " + iban.ibanCheck(ibf));
    }
}
