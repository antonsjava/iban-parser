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

import java.util.Iterator;
import java.util.List;
import sk.antons.jaul.Is;
import sk.antons.jaul.Replace;
import sk.antons.jaul.Split;
import sk.antons.jaul.binary.HtmlEraser;

/**
 *
 * @author antons
 */
public class IbanConfigParser {


    public static void main(String[] argv) throws Exception {
        //Iterator<String> iter = Split.file("src/test/resources/iban.html", "utf-8").byLines();
        Iterator<String> iter = Split.file("src/test/resources/iban2.html", "utf-8").byLines();
        int index = 0;
        String country = null;
        String length = null;
        String checkseq = null;
        String pattern = null;
        while(iter.hasNext()) {
            String line = iter.next();
            if(line.contains("<td ")) {
                String value = HtmlEraser.of(line).erase().trim();
                country = value;
            } else if(line.contains("<td>")) {
                String value = line.substring(4).trim();
                if(index == 0) {
                    length = value;
                } else if(index == 1) {
                    checkseq = value;
                } else if(index == 2) {
                    value = HtmlEraser.of(value).erase().trim();
                    pattern = value;
                } else {
                    value = HtmlEraser.of(value).erase().trim();
                    System.out.println(" -------- \n" + value);
                }
                index++;
            } else if(line.contains("/tr")) {
                if(pattern != null) {
                    System.out.println(" country: " + country + " len:" + length + " check: " + checkseq + " pattern: " + pattern);
                    pattern = Replace.all(pattern, " ", "");
                    String id = pattern.substring(0, 2);
                    System.out.println("    public static IbanConfig "+id+" = IbanConfig.instance(\""+id+"\").length("+length+").pattern(\""+pattern+"\")"+checks(checkseq)+";");
                }
                index = 0;
                country = null;
                length = null;
                checkseq = null;
                pattern = null;
            }
        }

    }

    private static String checks(String config) {
        StringBuilder sb = new StringBuilder();
        if(Is.empty(config)) return sb.toString();
        List<String> list = Split.string(config).bySubstringsToList(",");
        int position = 4;
        for(String string : list) {
            string = string.trim();
            if(Is.empty(string)) continue;
            String num = string.substring(0, string.length()-1);
            int len = Integer.parseInt(num);
            char c = string.charAt(string.length() - 1);
            if(c == 'n') {
                sb.append(".numeric("+position+", "+(position + len)+")");
            } else if(c == 'a') {
                sb.append(".capitals("+position+", "+(position + len)+")");
            } else if(c == 'c') {
                sb.append(".letters("+position+", "+(position + len)+")");
            } else {
            }
            position = position + len;
        }
        return sb.toString();
    }
}
