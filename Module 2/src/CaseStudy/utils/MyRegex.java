package CaseStudy.utils;

public class MyRegex {
    public static final String REGEX_IDSERVICE  ="^ $";
    public static final String REGEX_NAMESERVICE  ="^[A-Z][a-z1-9]+$";
    public static final String REGEX_AREA  ="^([3-9][0-9]+|[1-9][0-9]{2,})[.][0-9]+$";
    public static final String REGEX_POOLAREA  ="^([3-9][0-9]+|[1-9][0-9]{2,})[.][0-9]+$";
    public static final String REGEX_PRICE  ="^^[1-9][0-9]*$";
    public static final String REGEX_NUMBERPEOPLE  ="^1?[0-9]$";
    public static final String REGEX_NUMBERFLOOR  ="^[1-9][0-9]*$";
    public static final String REGEX_TYPERENT  ="^(Date|Month|Year)$";
    public static final String REGEX_QUALITY  ="^(Standard|Superior|Deluxe|Suite)$";

}
