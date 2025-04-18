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

import java.util.ArrayList;
import java.util.List;

/**
 * Configuration for iban.
 * @author antons
 */
public class IbanConfig {
    String id;
    int length;
    String pattern;
    List<IbanSubstringCheck> substringChecks;

    protected IbanConfig(String countryCode) {
        this.id = countryCode;
    }


    /**
     * Create new instance of IbanConfig for given country code
     * @param countryCode two digit country code used as start of iban
     * @return new IbanConfig instance
     */
    public static IbanConfig instance(String countryCode) { return new IbanConfig(countryCode); }
    /**
     * Country code
     * @return country code
     */
    public String id() { return id; }
    /**
     * Length of iban
     * @return length
     */
    public int length() { return length; }
    public IbanConfig length(int value) { this.length = value; return this; }
    /**
     * Pattern of iban. something like "SKkkbbbbppppppcccccccccc".
     * @return
     */
    public String pattern() { return pattern; }
    public IbanConfig pattern(String value) { this.pattern = value; return this; }
    public List<IbanSubstringCheck> substringChecks() { return substringChecks; }
    /**
     * Add new format check
     * @param value format check
     * @return this
     */
    public IbanConfig substringCheck(IbanSubstringCheck value) {
        if(value == null) return this;
        if(this.substringChecks == null) this.substringChecks = new ArrayList<>();
        this.substringChecks.add(value);
        return this;
    }
    /**
     * Add format check for digits in specified interval.
     * @param startPos start position (inclusive)
     * @param endPos end position (exclusive)
     * @return this.
     */
    public IbanConfig numeric(int startPos, int endPos) {
        return substringCheck(IbanSubstringCheck.numeric(startPos, endPos));
    }
    /**
     * Add format check for capital letters in specified interval.
     * @param startPos start position (inclusive)
     * @param endPos end position (exclusive)
     * @return this.
     */
    public IbanConfig capitals(int startPos, int endPos) {
        return substringCheck(IbanSubstringCheck.capitals(startPos, endPos));
    }
    /**
     * Add format check for digits or letters in specified interval.
     * @param startPos start position (inclusive)
     * @param endPos end position (exclusive)
     * @return this.
     */
    public IbanConfig letters(int startPos, int endPos) {
        return substringCheck(IbanSubstringCheck.letters(startPos, endPos));
    }


    private int cachedResolversSize = 0;
    private char[] cachedResolverChars;
    private IbanSubstringResolver[] cachedResolvers;

    protected synchronized IbanSubstringResolver resolver(char c) {
        if(cachedResolversSize == 0) {
            cachedResolverChars = new char[30];
            cachedResolvers = new IbanSubstringResolver[30];
        }
        if(cachedResolversSize == cachedResolvers.length) {
            char[] newcachedResolverChars = new char[cachedResolversSize + 30];
            IbanSubstringResolver[] newcachedResolvers = new IbanSubstringResolver[cachedResolversSize + 30];
            System.arraycopy(cachedResolverChars, 0, newcachedResolverChars, 0, cachedResolversSize);
            System.arraycopy(cachedResolvers, 0, newcachedResolvers, 0, cachedResolversSize);
            cachedResolverChars = newcachedResolverChars;
            cachedResolvers = newcachedResolvers;
        }

        int pos = -1;
        for(int i = 0; i < cachedResolversSize; i++) {
            if(cachedResolverChars[i] == c) return cachedResolvers[i];
        }

        IbanSubstringResolver r = resolveResolver(c);
        cachedResolverChars[cachedResolversSize] = c;
        cachedResolvers[cachedResolversSize] = r;
        cachedResolversSize++;

        return r;
    }

    private IbanSubstringResolver resolveResolver(char c) {
        int startPos = -1;
        int endPos = -1;
        int len = pattern.length();
        for(int i = 0; i < len; i++) {
            char cc = pattern.charAt(i);
            if(cc == c) {
                if(startPos == -1) {
                    startPos = i;
                } else {
                    if(endPos == -1) {
                        // OK
                    } else {
                        return IbanSubstringResolver.Pattern.instance(c, pattern);
                    }
                }
            } else {
                if(startPos == -1) {
                    // ok
                } else {
                    if(endPos == -1) {
                        endPos = i;
                    } else {
                        // ok
                    }
                }
            }
        }

        if((startPos != -1) && (endPos == -1)) endPos = len;

        if(startPos != -1) return IbanSubstringResolver.Substring.instance(startPos, endPos);

        return IbanSubstringResolver.None.instance();
    }


    protected boolean formatCheck(String iban) {
        if(substringChecks == null) return true;
        for(IbanSubstringCheck substringCheck : substringChecks) {
            if(!substringCheck.validate(iban)) return false;
        }
        return true;
    }

    protected String format() {
        if(substringChecks == null) return null;
        StringBuilder sb = new StringBuilder();
        for(IbanSubstringCheck substringCheck : substringChecks) {
            if(sb.length() > 0) sb.append(",");
            sb.append(substringCheck);
        }
        return sb.toString();
    }

}
