# iban-parser

Helper library for parsing account numbers in IBAN form.

Known formats are taken from [here](https://en.wikipedia.org/wiki/International_Bank_Account_Number)

## usage

folowing code 

```
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
```
prints 
```
 iban: SK1709000000000024041632
 iban pretty : SK17 0900 0000 0000 2404 1632
 iban pattern : SKkkbbbbppppppcccccccccc
 iban format : 0[4-24]
 iban check length : true
 iban check format : true
 iban check iban : true
 iban accountNumber : 0024041632
 iban accountNumberPrefix : 000000
 iban nationalBankNumber : 0900
 iban bic : null
 iban currency : null
 iban branch : null
 iban accountType : null
 iban checkDigits : null
 iban patternPart : 0900
 iban SK1709000000000024041632 check : true
 iban SK1709000000000024041632 check : true
 iban SK1509000000000024041632 check : false
 iban SK1709000000000024041632 check : true
 iban SK7509000000000024041632 check : false
 iban SK1709000000000024041632 check : true
```

