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

/**
 * Registry of known iban formats. It is taken from https://en.wikipedia.org/wiki/International_Bank_Account_Number
 * @author antons
 */
public class IbanConfigRepository {


    public static IbanConfig AL = IbanConfig.instance("AL").length(28).pattern("ALkkbbbssssxcccccccccccccccc").numeric(4, 12).letters(12, 28);
    public static IbanConfig AD = IbanConfig.instance("AD").length(24).pattern("ADkkbbbbsssscccccccccccc").numeric(4, 12).letters(12, 24);
    public static IbanConfig AT = IbanConfig.instance("AT").length(20).pattern("ATkkbbbbbccccccccccc").numeric(4, 20);
    public static IbanConfig AZ = IbanConfig.instance("AZ").length(28).pattern("AZkkbbbbcccccccccccccccccccc").capitals(4, 8).letters(8, 28);
    public static IbanConfig BH = IbanConfig.instance("BH").length(22).pattern("BHkkbbbbcccccccccccccc").capitals(4, 8).letters(8, 22);
    public static IbanConfig BY = IbanConfig.instance("BY").length(28).pattern("BYkkbbbbaaaacccccccccccccccc").letters(4, 8).numeric(8, 12).letters(12, 28);
    public static IbanConfig BE = IbanConfig.instance("BE").length(16).pattern("BEkkbbbcccccccxx").numeric(4, 16);
    public static IbanConfig BA = IbanConfig.instance("BA").length(20).pattern("BAkkbbbsssccccccccxx").numeric(4, 20);
    public static IbanConfig BR = IbanConfig.instance("BR").length(29).pattern("BRkkbbbbbbbbssssscccccccccctn").numeric(4, 27).capitals(27, 28).letters(28, 29);
    public static IbanConfig BG = IbanConfig.instance("BG").length(22).pattern("BGkkqqqqssssttcccccccc").capitals(4, 8).numeric(8, 14).letters(14, 22);
    public static IbanConfig BI = IbanConfig.instance("BI").length(27).pattern("BIkkbbbbbsssssccccccccccccc").numeric(4, 9).numeric(9, 14).numeric(14, 25).numeric(25, 27);
    public static IbanConfig CR = IbanConfig.instance("CR").length(22).pattern("CRkk0bbbcccccccccccccc").numeric(4, 22);
    public static IbanConfig HR = IbanConfig.instance("HR").length(21).pattern("HRkkbbbbbbbcccccccccc").numeric(4, 21);
    public static IbanConfig CY = IbanConfig.instance("CY").length(28).pattern("CYkkbbbssssscccccccccccccccc").numeric(4, 12).letters(12, 28);
    public static IbanConfig CZ = IbanConfig.instance("CZ").length(24).pattern("CZkkbbbbppppppcccccccccc").numeric(4, 24);
    public static IbanConfig DK = IbanConfig.instance("DK").length(18).pattern("DKkkbbbbcccccccccx").numeric(4, 18);
    public static IbanConfig DJ = IbanConfig.instance("DJ").length(27).pattern("DJkkbbbbbsssssccccccccccccc").numeric(4, 9).numeric(9, 14).numeric(14, 25).numeric(25, 27);
    public static IbanConfig DO = IbanConfig.instance("DO").length(28).pattern("DOkkbbbbcccccccccccccccccccc").letters(4, 8).numeric(8, 28);
    public static IbanConfig TL = IbanConfig.instance("TL").length(23).pattern("TLkkbbbccccccccccccccxx").numeric(4, 23);
    public static IbanConfig EG = IbanConfig.instance("EG").length(29).pattern("EGkkbbbbssssccccccccccccccccc").numeric(4, 29);
    public static IbanConfig SV = IbanConfig.instance("SV").length(28).pattern("SVkkbbbbcccccccccccccccccccc").capitals(4, 8).numeric(8, 28);
    public static IbanConfig EE = IbanConfig.instance("EE").length(20).pattern("EEkkbbsscccccccccccx").numeric(4, 20);
    public static IbanConfig FK = IbanConfig.instance("FK").length(18).pattern("FKkkbbcccccccccccc").capitals(4, 6).numeric(6, 18);
    public static IbanConfig FO = IbanConfig.instance("FO").length(18).pattern("FOkkbbbbcccccccccx").numeric(4, 18);
    public static IbanConfig FI = IbanConfig.instance("FI").length(18).pattern("FIkkbbbbbbcccccccx").numeric(4, 18);
    public static IbanConfig FR = IbanConfig.instance("FR").length(27).pattern("FRkkbbbbbssssscccccccccccxx").numeric(4, 14).letters(14, 25).numeric(25, 27);
    public static IbanConfig GE = IbanConfig.instance("GE").length(22).pattern("GEkkbbcccccccccccccccc").capitals(4, 6).numeric(6, 22);
    public static IbanConfig DE = IbanConfig.instance("DE").length(22).pattern("DEkkbbbbbbbbcccccccccc").numeric(4, 22);
    public static IbanConfig GI = IbanConfig.instance("GI").length(23).pattern("GIkkqqqqccccccccccccccc").capitals(4, 8).letters(8, 23);
    public static IbanConfig GR = IbanConfig.instance("GR").length(27).pattern("GRkkbbbsssscccccccccccccccc").numeric(4, 11).letters(11, 27);
    public static IbanConfig GL = IbanConfig.instance("GL").length(18).pattern("GLkkbbbbcccccccccx").numeric(4, 18);
    public static IbanConfig GT = IbanConfig.instance("GT").length(28).pattern("GTkkbbbbmmttcccccccccccccccc").letters(4, 8).letters(8, 28);
    public static IbanConfig HU = IbanConfig.instance("HU").length(28).pattern("HUkkbbbssssxcccccccccccccccx").numeric(4, 28);
    public static IbanConfig IS = IbanConfig.instance("IS").length(26).pattern("ISkkbbssttcccccciiiiiiiiii").numeric(4, 26);
    public static IbanConfig IQ = IbanConfig.instance("IQ").length(23).pattern("IQkkbbbbssscccccccccccc").capitals(4, 8).numeric(8, 23);
    public static IbanConfig IE = IbanConfig.instance("IE").length(22).pattern("IEkkqqqqbbbbbbcccccccc").capitals(4, 8).numeric(8, 14).numeric(14, 22);
    public static IbanConfig IL = IbanConfig.instance("IL").length(23).pattern("ILkkbbbsssccccccccccccc").numeric(4, 23);
    public static IbanConfig IT = IbanConfig.instance("IT").length(27).pattern("ITkkxbbbbbssssscccccccccccc").capitals(4, 5).numeric(5, 15).letters(15, 27);
    public static IbanConfig JO = IbanConfig.instance("JO").length(30).pattern("JOkkbbbbsssscccccccccccccccccc").capitals(4, 8).numeric(8, 12).letters(12, 30);
    public static IbanConfig KZ = IbanConfig.instance("KZ").length(20).pattern("KZkkbbbccccccccccccc").numeric(4, 7).letters(7, 20);
    public static IbanConfig XK = IbanConfig.instance("XK").length(20).pattern("XKkkbbbbcccccccccccc").numeric(4, 8).numeric(8, 18).numeric(18, 20);
    public static IbanConfig KW = IbanConfig.instance("KW").length(30).pattern("KWkkbbbbcccccccccccccccccccccc").capitals(4, 8).letters(8, 30);
    public static IbanConfig LV = IbanConfig.instance("LV").length(21).pattern("LVkkqqqqccccccccccccc").capitals(4, 8).letters(8, 21);
    public static IbanConfig LB = IbanConfig.instance("LB").length(28).pattern("LBkkbbbbcccccccccccccccccccc").numeric(4, 8).letters(8, 28);
    public static IbanConfig LY = IbanConfig.instance("LY").length(25).pattern("LYkkbbbsssccccccccccccccc").numeric(4, 25);
    public static IbanConfig LI = IbanConfig.instance("LI").length(21).pattern("LIkkbbbbbcccccccccccc").numeric(4, 9).letters(9, 21);
    public static IbanConfig LT = IbanConfig.instance("LT").length(20).pattern("LTkkbbbbbccccccccccc").numeric(4, 20);
    public static IbanConfig LU = IbanConfig.instance("LU").length(20).pattern("LUkkbbbccccccccccccc").numeric(4, 7).letters(7, 20);
    public static IbanConfig MT = IbanConfig.instance("MT").length(31).pattern("MTkkqqqqssssscccccccccccccccccc").capitals(4, 8).numeric(8, 13).letters(13, 31);
    public static IbanConfig MR = IbanConfig.instance("MR").length(27).pattern("MRkkbbbbbssssscccccccccccxx").numeric(4, 27);
    public static IbanConfig MU = IbanConfig.instance("MU").length(30).pattern("MUkkbbbbbbsscccccccccccc000mmm").capitals(4, 8).numeric(8, 27).capitals(27, 30);
    public static IbanConfig MC = IbanConfig.instance("MC").length(27).pattern("MCkkbbbbbssssscccccccccccxx").numeric(4, 14).letters(14, 25).numeric(25, 27);
    public static IbanConfig MD = IbanConfig.instance("MD").length(24).pattern("MDkkbbcccccccccccccccccc").letters(4, 6).letters(6, 24);
    public static IbanConfig MN = IbanConfig.instance("MN").length(20).pattern("MNkkbbbbcccccccccccc").numeric(4, 8).numeric(8, 20);
    public static IbanConfig ME = IbanConfig.instance("ME").length(22).pattern("MEkkbbbcccccccccccccxx").numeric(4, 22);
    public static IbanConfig NL = IbanConfig.instance("NL").length(18).pattern("NLkkqqqqcccccccccc").capitals(4, 8).numeric(8, 18);
    public static IbanConfig NI = IbanConfig.instance("NI").length(28).pattern("NIkkbbbbcccccccccccccccccccc").capitals(4, 8).numeric(8, 28);
    public static IbanConfig MK = IbanConfig.instance("MK").length(19).pattern("MKkkbbbccccccccccxx").numeric(4, 7).letters(7, 17).numeric(17, 19);
    public static IbanConfig NO = IbanConfig.instance("NO").length(15).pattern("NOkkbbbbccccccx").numeric(4, 15);
    public static IbanConfig OM = IbanConfig.instance("OM").length(23).pattern("OMkkbbbcccccccccccccccc").numeric(4, 7).letters(7, 23);
    public static IbanConfig PK = IbanConfig.instance("PK").length(24).pattern("PKkkbbbbcccccccccccccccc").capitals(4, 8).letters(8, 24);
    public static IbanConfig PS = IbanConfig.instance("PS").length(29).pattern("PSkkbbbbccccccccccccccccccccc").capitals(4, 8).letters(8, 29);
    public static IbanConfig PL = IbanConfig.instance("PL").length(28).pattern("PLkkbbbssssxcccccccccccccccc").numeric(4, 28);
    public static IbanConfig PT = IbanConfig.instance("PT").length(25).pattern("PTkkbbbbsssscccccccccccxx").numeric(4, 25);
    public static IbanConfig QA = IbanConfig.instance("QA").length(29).pattern("QAkkbbbbccccccccccccccccccccc").capitals(4, 8).letters(8, 29);
    public static IbanConfig RO = IbanConfig.instance("RO").length(24).pattern("ROkkqqqqcccccccccccccccc").capitals(4, 8).letters(8, 24);
    public static IbanConfig RU = IbanConfig.instance("RU").length(33).pattern("RUkkbbbbbbbbbsssssccccccccccccccc").numeric(4, 13).letters(13, 33);
    public static IbanConfig LC = IbanConfig.instance("LC").length(32).pattern("LCkkbbbbcccccccccccccccccccccccc").capitals(4, 8).letters(8, 32);
    public static IbanConfig SM = IbanConfig.instance("SM").length(27).pattern("SMkkxbbbbbssssscccccccccccc").capitals(4, 5).numeric(5, 15).letters(15, 27);
    public static IbanConfig ST = IbanConfig.instance("ST").length(25).pattern("STkkbbbbssssccccccccccccc").numeric(4, 25);
    public static IbanConfig SA = IbanConfig.instance("SA").length(24).pattern("SAkkbbcccccccccccccccccc").numeric(4, 6).letters(6, 24);
    public static IbanConfig RS = IbanConfig.instance("RS").length(22).pattern("RSkkbbbcccccccccccccxx").numeric(4, 22);
    public static IbanConfig SC = IbanConfig.instance("SC").length(31).pattern("SCkkbbbbbbssccccccccccccccccmmm").capitals(4, 8).numeric(8, 28).capitals(28, 31);
    public static IbanConfig SK = IbanConfig.instance("SK").length(24).pattern("SKkkbbbbppppppcccccccccc").numeric(4, 24);
    public static IbanConfig SI = IbanConfig.instance("SI").length(19).pattern("SIkkbbsssccccccccxx").numeric(4, 19);
    public static IbanConfig SO = IbanConfig.instance("SO").length(23).pattern("SOkkbbbbssscccccccccccc").numeric(4, 8).numeric(8, 11).numeric(11, 23);
    public static IbanConfig ES = IbanConfig.instance("ES").length(24).pattern("ESkkbbbbssssxxcccccccccc").numeric(4, 24);
    public static IbanConfig SD = IbanConfig.instance("SD").length(18).pattern("SDkkbbcccccccccccc").numeric(4, 18);
    public static IbanConfig SE = IbanConfig.instance("SE").length(24).pattern("SEkkbbbccccccccccccccccx").numeric(4, 24);
    public static IbanConfig CH = IbanConfig.instance("CH").length(21).pattern("CHkkbbbbbcccccccccccc").numeric(4, 9).letters(9, 21);
    public static IbanConfig TN = IbanConfig.instance("TN").length(24).pattern("TNkkbbssscccccccccccccxx").numeric(4, 24);
    public static IbanConfig TR = IbanConfig.instance("TR").length(26).pattern("TRkkbbbbb0cccccccccccccccc").numeric(4, 9).numeric(9, 10).letters(10, 26);
    public static IbanConfig UA = IbanConfig.instance("UA").length(29).pattern("UAkkbbbbbbccccccccccccccccccc").numeric(4, 10).letters(10, 29);
    public static IbanConfig AE = IbanConfig.instance("AE").length(23).pattern("AEkkbbbcccccccccccccccc").numeric(4, 7).numeric(7, 23);
    public static IbanConfig GB = IbanConfig.instance("GB").length(22).pattern("GBkkqqqqsssssscccccccc").capitals(4, 8).numeric(8, 22);
    public static IbanConfig VA = IbanConfig.instance("VA").length(22).pattern("VAkkbbbccccccccccccccc").numeric(4, 7).numeric(7, 22);
    public static IbanConfig VG = IbanConfig.instance("VG").length(24).pattern("VGkkbbbbcccccccccccccccc").capitals(4, 8).numeric(8, 24);
    public static IbanConfig YE = IbanConfig.instance("YE").length(30).pattern("YEkkbbbbsssscccccccccccccccccc").capitals(4, 8).numeric(8, 12).letters(12, 30);

    public static IbanConfig DZ = IbanConfig.instance("DZ").length(26).pattern("DZkknnnnnnnnnnnnnnnnnnnnnn").numeric(4, 26);
    public static IbanConfig AO = IbanConfig.instance("AO").length(25).pattern("AOkknnnnnnnnnnnnnnnnnnnnn").numeric(4, 25);
    public static IbanConfig BJ = IbanConfig.instance("BJ").length(28).pattern("BJkkccnnnnnnnnnnnnnnnnnnnnnn").letters(4, 6).numeric(6, 28);
    public static IbanConfig BF = IbanConfig.instance("BF").length(28).pattern("BFkkccnnnnnnnnnnnnnnnnnnnnnn").letters(4, 6).numeric(6, 28);
    public static IbanConfig CV = IbanConfig.instance("CV").length(25).pattern("CVkknnnnnnnnnnnnnnnnnnnnn").numeric(4, 25);
    public static IbanConfig CM = IbanConfig.instance("CM").length(27).pattern("CMkknnnnnnnnnnnnnnnnnnnnnnn").numeric(4, 27);
    public static IbanConfig CF = IbanConfig.instance("CF").length(27).pattern("CFkknnnnnnnnnnnnnnnnnnnnnnn").numeric(4, 27);
    public static IbanConfig TD = IbanConfig.instance("TD").length(27).pattern("TDkknnnnnnnnnnnnnnnnnnnnnnn").numeric(4, 27);
    public static IbanConfig KM = IbanConfig.instance("KM").length(27).pattern("KMkknnnnnnnnnnnnnnnnnnnnnnn").numeric(4, 27);
    public static IbanConfig CG = IbanConfig.instance("CG").length(27).pattern("CGkknnnnnnnnnnnnnnnnnnnnnnn").numeric(4, 27);
    public static IbanConfig CI = IbanConfig.instance("CI").length(28).pattern("CIkkaannnnnnnnnnnnnnnnnnnnnn").capitals(4, 6).numeric(6, 28);
    public static IbanConfig GQ = IbanConfig.instance("GQ").length(27).pattern("GQkknnnnnnnnnnnnnnnnnnnnnnn").numeric(4, 27);
    public static IbanConfig GA = IbanConfig.instance("GA").length(27).pattern("GAkknnnnnnnnnnnnnnnnnnnnnnn").numeric(4, 27);
    public static IbanConfig GW = IbanConfig.instance("GW").length(25).pattern("GWkkccnnnnnnnnnnnnnnnnnnn").letters(4, 6).numeric(6, 25);
    public static IbanConfig HN = IbanConfig.instance("HN").length(28).pattern("HNkkaaaannnnnnnnnnnnnnnnnnnn").capitals(4, 8).numeric(8, 28);
    public static IbanConfig IR = IbanConfig.instance("IR").length(26).pattern("IRkknnnnnnnnnnnnnnnnnnnnnn").numeric(4, 26);
    public static IbanConfig MG = IbanConfig.instance("MG").length(27).pattern("MGkknnnnnnnnnnnnnnnnnnnnnnn").numeric(4, 27);
    public static IbanConfig ML = IbanConfig.instance("ML").length(28).pattern("MLkkccnnnnnnnnnnnnnnnnnnnnnn").letters(4, 6).numeric(6, 28);
    public static IbanConfig MA = IbanConfig.instance("MA").length(28).pattern("MAkknnnnnnnnnnnnnnnnnnnnnnnn").numeric(4, 28);
    public static IbanConfig MZ = IbanConfig.instance("MZ").length(25).pattern("MZkknnnnnnnnnnnnnnnnnnnnn").numeric(4, 25);
    public static IbanConfig NE = IbanConfig.instance("NE").length(28).pattern("NEkkaannnnnnnnnnnnnnnnnnnnnn").capitals(4, 6).numeric(6, 28);
    public static IbanConfig SN = IbanConfig.instance("SN").length(28).pattern("SNkkaannnnnnnnnnnnnnnnnnnnnn").capitals(4, 6).numeric(6, 28);
    public static IbanConfig TG = IbanConfig.instance("TG").length(28).pattern("TGkkaannnnnnnnnnnnnnnnnnnnnn").capitals(4, 6).numeric(6, 28);

    /**
     * Try to find IbanConfig using first two letters of given iban.
     * @param iban given iban
     * @return config
     */
    public static IbanConfig parse(String iban) {
        if(iban == null) return null;
        if(iban.length() < 2) throw new IllegalArgumentException("unable to identify country from " + iban);
        char c1 = iban.charAt(0);
        char c2 = iban.charAt(1);
        switch(c1) {
            case 'A':
                switch(c2) {
                    case 'D': return AD;
                    case 'E': return AE;
                    case 'L': return AL;
                    case 'O': return AO;
                    case 'T': return AT;
                    case 'Z': return AZ;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'B':
                switch(c2) {
                    case 'A': return BA;
                    case 'E': return BE;
                    case 'F': return BF;
                    case 'G': return BG;
                    case 'H': return BH;
                    case 'I': return BI;
                    case 'J': return BJ;
                    case 'R': return BR;
                    case 'Y': return BY;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'C':
                switch(c2) {
                    case 'F': return CF;
                    case 'H': return CH;
                    case 'R': return CR;
                    case 'Y': return CY;
                    case 'Z': return CZ;
                    case 'J': return BJ;
                    case 'G': return CG;
                    case 'I': return CI;
                    case 'M': return CM;
                    case 'V': return CV;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'D':
                switch(c2) {
                    case 'E': return DE;
                    case 'J': return DJ;
                    case 'K': return DK;
                    case 'O': return DO;
                    case 'Z': return DZ;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'E':
                switch(c2) {
                    case 'E': return EE;
                    case 'G': return EG;
                    case 'S': return ES;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'F':
                switch(c2) {
                    case 'I': return FI;
                    case 'K': return FK;
                    case 'O': return FO;
                    case 'R': return FR;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'G':
                switch(c2) {
                    case 'B': return GB;
                    case 'E': return GE;
                    case 'I': return GI;
                    case 'L': return GL;
                    case 'R': return GR;
                    case 'T': return GT;
                    case 'A': return GA;
                    case 'Q': return GQ;
                    case 'W': return GW;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'H':
                switch(c2) {
                    case 'R': return HR;
                    case 'U': return HU;
                    case 'N': return HN;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'I':
                switch(c2) {
                    case 'E': return IE;
                    case 'L': return IL;
                    case 'Q': return IQ;
                    case 'S': return IS;
                    case 'T': return IT;
                    case 'R': return IR;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'J':
                switch(c2) {
                    case 'O': return JO;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'K':
                switch(c2) {
                    case 'W': return KW;
                    case 'Z': return KZ;
                    case 'M': return KM;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'L':
                switch(c2) {
                    case 'B': return LB;
                    case 'C': return LC;
                    case 'I': return LI;
                    case 'T': return LT;
                    case 'U': return LU;
                    case 'V': return LV;
                    case 'Y': return LY;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'M':
                switch(c2) {
                    case 'C': return MC;
                    case 'D': return MD;
                    case 'E': return ME;
                    case 'K': return MK;
                    case 'N': return MN;
                    case 'R': return MR;
                    case 'T': return MT;
                    case 'U': return MU;
                    case 'A': return MA;
                    case 'G': return MG;
                    case 'L': return ML;
                    case 'Z': return MZ;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'N':
                switch(c2) {
                    case 'I': return NI;
                    case 'L': return NL;
                    case 'O': return NO;
                    case 'Z': return MZ;
                    case 'E': return NE;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'O':
                switch(c2) {
                    case 'M': return OM;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'P':
                switch(c2) {
                    case 'K': return PK;
                    case 'L': return PL;
                    case 'S': return PS;
                    case 'T': return PT;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'Q':
                switch(c2) {
                    case 'A': return QA;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'R':
                switch(c2) {
                    case 'O': return RO;
                    case 'S': return RS;
                    case 'U': return RU;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'S':
                switch(c2) {
                    case 'A': return SA;
                    case 'C': return SC;
                    case 'D': return SD;
                    case 'E': return SE;
                    case 'I': return SI;
                    case 'K': return SK;
                    case 'M': return SM;
                    case 'O': return SO;
                    case 'T': return ST;
                    case 'V': return SV;
                    case 'N': return SN;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'T':
                switch(c2) {
                    case 'L': return TL;
                    case 'N': return TN;
                    case 'R': return TR;
                    case 'D': return TD;
                    case 'G': return TG;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'U':
                switch(c2) {
                    case 'A': return UA;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'V':
                switch(c2) {
                    case 'A': return VA;
                    case 'G': return VG;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'X':
                switch(c2) {
                    case 'K': return XK;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            case 'Y':
                switch(c2) {
                    case 'E': return YE;
                    default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
                }
            default: throw new IllegalArgumentException("unable to identify country from " + ((char)c1) + ((char)c2));
        }
    }

}
