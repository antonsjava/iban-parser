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
package adhoc;

import sk.antons.iban.Iban;
import static sk.antons.iban.Iban.ibanFix;

/**
 *
 * @author antons
 */
public class Checker {

    private static String[] ibans = new String[] {
"AL35202111090000000001234567",
"AD1400080001001234567890",
"AT483200000012345864",
"AZ77VTBA00000000001234567890",
"BH02CITI00001077181611",
"BY86AKBB10100000002966000000",
"BE71096123456769",
"BA393385804800211234",
"BR1500000000000010932840814P2",
"BG18RZBB91550123456789",
"BI1320001100010000123456789",
"CR23015108410026012345",
"HR1723600001101234565",
"CY21002001950000357001234567",
"CZ5508000000001234567899",
"DK9520000123456789",
"DJ2110002010010409943020008",
"DO22ACAU00000000000123456789",
"EG800002000156789012345180002",
"SV43ACAT00000000000000123123",
"EE471000001020145685",
"FK12SC987654321098",
"FO9264600123456789",
"FI1410093000123458",
"FR7630006000011234567890189",
"GE60NB0000000123456789",
"DE75512108001245126199",
"GI56XAPO000001234567890",
"GR9608100010000001234567890",
"GL8964710123456789",
"GT20AGRO00000000001234567890",
"VA59001123000012345678",
"HN54PISA00000000000000123124",
"HU93116000060000000012345676",
"IS750001121234563108962099",
"IQ20CBIQ861800101010500",
"IE64IRCE92050112345678",
"IL170108000000012612345",
"IT60X0542811101000000123456",
"JO71CBJO0000000000001234567890",
"KZ244350000012344567",
"XK051212012345678906",
"KW81CBKU0000000000001234560101",
"LV97HABA0012345678910",
"LB92000700000000123123456123",
"LY38021001000000123456789",
"LI7408806123456789012",
"LT601010012345678901",
"LU120010001234567891",
"MT31MALT01100000000000000000123",
"MR1300020001010000123456753",
"MU43BOMM0101123456789101000MUR",
"MD21EX000000000001234567",
"MC5810096180790123456789085",
"MN580050099123456789",
"ME25505000012345678951",
"NL02ABNA0123456789",
"NI79BAMC00000000000003123123",
"MK07200002785123453",
"NO8330001234567",
"PK36SCBL0000001123456702",
"PS92PALS000000000400123456702",
"PL10105000997603123456789123",
"PT50002700000001234567833",
"QA54QNBA000000000000693123456",
"RO66BACX0000001234567890",
"RU0204452560040702810412345678901",
"LC14BOSL123456789012345678901234",
"SM76P0854009812123456789123",
"ST23000200000289355710148",
"SA4420000001234567891234",
"RS35105008123123123173",
"SC74MCBL01031234567890123456USD",
"SK8975000000000012345671",
"SI56192001234567892",
"SO061000001123123456789",
"ES7921000813610123456789",
"SD8811123456789012",
"OM040280000012345678901",
"SE7280000810340009783242",
"CH5604835012345678009",
"TL380010012345678910106",
"TN5904018104004942712345",
"TR320010009999901234567890",
"UA903052992990004149123456789",
"AE460090000000123456789",
"GB33BUKB20201555555555",
"VG07ABVI0000000123456789",
"YE09CBKU0000000000001234560101",
    };

    private static void check(String ib) {
        Iban iban = Iban.instance(ib);
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
        String ibf = ibanFix(ib);
        System.out.println(" iban "+ib+" check : " + iban.ibanCheck(ib));
        System.out.println(" iban "+ibf+" check : " + iban.ibanCheck(ibf));

    }

    public static void main(String[] argv) {
        for(String iban : ibans) {
            check(iban);
        }
    }
}
