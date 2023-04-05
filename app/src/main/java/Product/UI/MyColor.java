package Product.UI;

import java.util.HashMap;

import Product.Service.DataCenter;
import facecat.topin.core.FCColor;
import facecat.topin.core.FCFile;
import facecat.topin.core.FCNative;
import facecat.topin.core.FCTran;
import facecat.topin.core.RefObject;
import topin.facecat.FaceCat.MainActivity;

/**
 * 我的颜色
 */
public class MyColor {
    public static String m_systemFont = "";

    /*
     * 设置系统字体
     */
    public static void setSystemFont(String value)
    {
        m_systemFont = value;
    }

    /*
    * 获取系统字体
     */
    public static String getSystemFont()
    {
        if (m_systemFont.length() == 0)
        {
            m_systemFont = "System";
        }
        return m_systemFont;
    }

    public static int m_reverseColor = -1;

    /*
    * 设置反色
     */
    public static void setReverseColor(int reverseColor)
    {
        m_reverseColor = reverseColor;
    }

    /*
    * 获取反色
     */
    public static int getReverseColor()
    {
        if (m_reverseColor == -1)
        {
            m_reverseColor = 0;
        }
        return m_reverseColor;
    }

    /*
    * 上次的样式
     */
    public int m_lastStyle = -1;

    /*
    * 默认样式
     */
    public static int m_style = 0;

    public static long USERCOLOR = -200000000100L;
    public static long USERCOLOR1 = -200000000100L;
    public static long USERCOLOR2 = -200000000101L;
    public static long USERCOLOR3 = -200000000102L;
    public static long USERCOLOR4 = -200000000103L;
    public static long USERCOLOR5 = -200000000104L;
    public static long USERCOLOR6 = -200000000105L;
    public static long USERCOLOR7 = -200000000106L;
    public static long USERCOLOR8 = -200000000107L;
    public static long USERCOLOR9 = -200000000108L;
    public static long USERCOLOR10 = -200000000109L;
    public static long USERCOLOR11 = -200000000110L;
    public static long USERCOLOR12 = -200000000111L;
    public static long USERCOLOR13 = -200000000112L;
    public static long USERCOLOR14 = -200000000113L;
    public static long USERCOLOR15 = -200000000114L;
    public static long USERCOLOR16 = -200000000115L;
    public static long USERCOLOR17 = -200000000116L;
    public static long USERCOLOR18 = -200000000117L;
    public static long USERCOLOR19 = -200000000118L;
    public static long USERCOLOR20 = -200000000119L;
    public static long USERCOLOR21 = -200000000120L;
    public static long USERCOLOR22 = -200000000121L;
    public static long USERCOLOR23 = -200000000122L;
    public static long USERCOLOR24 = -200000000123L;
    public static long USERCOLOR25 = -200000000124L;
    public static long USERCOLOR26 = -200000000125L;
    public static long USERCOLOR27 = -200000000126L;
    public static long USERCOLOR28 = -200000000127L;
    public static long USERCOLOR29 = -200000000128L;
    public static long USERCOLOR30 = -200000000129L;
    public static long USERCOLOR31 = -200000000130L;
    public static long USERCOLOR32 = -200000000131L;
    public static long USERCOLOR33 = -200000000132L;
    public static long USERCOLOR34 = -200000000133L;
    public static long USERCOLOR35 = -200000000134L;
    public static long USERCOLOR36 = -200000000135L;
    public static long USERCOLOR37 = -200000000136L;
    public static long USERCOLOR38 = -200000000137L;
    public static long USERCOLOR39 = -200000000138L;
    public static long USERCOLOR40 = -200000000139L;
    public static long USERCOLOR41 = -200000000140L;
    public static long USERCOLOR42 = -200000000141L;
    public static long USERCOLOR43 = -200000000142L;
    public static long USERCOLOR44 = -200000000143L;
    public static long USERCOLOR45 = -200000000144L;
    public static long USERCOLOR46 = -200000000145L;
    public static long USERCOLOR47 = -200000000146L;
    public static long USERCOLOR48 = -200000000147L;
    public static long USERCOLOR49 = -200000000148L;
    public static long USERCOLOR50 = -200000000149L;
    public static long USERCOLOR51 = -200000000150L;
    public static long USERCOLOR52 = -200000000151L;
    public static long USERCOLOR53 = -200000000152L;
    public static long USERCOLOR54 = -200000000153L;
    public static long USERCOLOR55 = -200000000154L;
    public static long USERCOLOR56 = -200000000155L;
    public static long USERCOLOR57 = -200000000156L;
    public static long USERCOLOR58 = -200000000157L;
    public static long USERCOLOR59 = -200000000158L;
    public static long USERCOLOR60 = -200000000159L;
    public static long USERCOLOR61 = -200000000160L;
    public static long USERCOLOR62 = -200000000161L;
    public static long USERCOLOR63 = -200000000162L;
    public static long USERCOLOR64 = -200000000163L;
    public static long USERCOLOR65 = -200000000164L;
    public static long USERCOLOR66 = -200000000165L;
    public static long USERCOLOR67 = -200000000166L;
    public static long USERCOLOR68 = -200000000167L;
    public static long USERCOLOR69 = -200000000168L;
    public static long USERCOLOR70 = -200000000169L;
    public static long USERCOLOR71 = -200000000170L;
    public static long USERCOLOR72 = -200000000171L;
    public static long USERCOLOR73 = -200000000172L;
    public static long USERCOLOR74 = -200000000173L;
    public static long USERCOLOR75 = -200000000174L;
    public static long USERCOLOR76 = -200000000175L;
    public static long USERCOLOR77 = -200000000176L;
    public static long USERCOLOR78 = -200000000177L;
    public static long USERCOLOR79 = -200000000178L;
    public static long USERCOLOR80 = -200000000179L;
    public static long USERCOLOR81 = -200000000180L;
    public static long USERCOLOR82 = -200000000181L;
    public static long USERCOLOR83 = -200000000182L;
    public static long USERCOLOR84 = -200000000183L;
    public static long USERCOLOR85 = -200000000184L;
    public static long USERCOLOR86 = -200000000185L;
    public static long USERCOLOR87 = -200000000186L;
    public static long USERCOLOR88 = -200000000187L;
    public static long USERCOLOR89 = -200000000188L;
    public static long USERCOLOR90 = -200000000189L;
    public static long USERCOLOR91 = -200000000190L;
    public static long USERCOLOR92 = -200000000191L;
    public static long USERCOLOR93 = -200000000192L;
    public static long USERCOLOR94 = -200000000193L;
    public static long USERCOLOR95 = -200000000194L;
    public static long USERCOLOR96 = -200000000195L;
    public static long USERCOLOR97 = -200000000196L;
    public static long USERCOLOR98 = -200000000197L;
    public static long USERCOLOR99 = -200000000198L;
    public static long USERCOLOR100 = -200000000199L;
    public static long USERCOLOR101 = -200000000200L;
    public static long USERCOLOR102 = -200000000201L;
    public static long USERCOLOR103 = -200000000202L;
    public static long USERCOLOR104 = -200000000203L;
    public static long USERCOLOR105 = -200000000204L;
    public static long USERCOLOR106 = -200000000205L;
    public static long USERCOLOR107 = -200000000206L;
    public static long USERCOLOR108 = -200000000207L;
    public static long USERCOLOR109 = -200000000208L;
    public static long USERCOLOR110 = -200000000209L;
    public static long USERCOLOR111 = -200000000210L;
    public static long USERCOLOR112 = -200000000211L;
    public static long USERCOLOR113 = -200000000212L;
    public static long USERCOLOR114 = -200000000213L;
    public static long USERCOLOR115 = -200000000214L;
    public static long USERCOLOR116 = -200000000215L;
    public static long USERCOLOR117 = -200000000216L;

    /*
    * 自定义颜色
     */
    public HashMap<Long, Long> m_userColors = new HashMap<Long, Long>();

    /*
    * 我的颜色
     */
    public static HashMap<Long, Long> m_myColors = new HashMap<Long, Long>();

    /*
    * 设置样式
     */
    public static void setStyle(int value){
        m_style = value;
    }

    /**
     * 创建颜色
     */
    public void createColors(){
        m_userColors.clear();
        if (m_style == 1)
        {
            m_userColors.put(USERCOLOR, FCColor.rgb(0, 0, 0));
            m_userColors.put(USERCOLOR1, FCColor.rgb(0, 0, 0));
            m_userColors.put(USERCOLOR2, FCColor.rgba(0, 0, 0, 100)); //1
            m_userColors.put(USERCOLOR3, FCColor.rgb(0, 0, 0)); //1
            m_userColors.put(USERCOLOR4, FCColor.rgb(0, 0, 0)); //1
            m_userColors.put(USERCOLOR5, FCColor.rgb(42, 138, 195));
            m_userColors.put(USERCOLOR6, FCColor.rgba(0, 0, 0, 25)); //1
            m_userColors.put(USERCOLOR7, FCColor.rgb(255, 255, 255)); //1
            m_userColors.put(USERCOLOR8, FCColor.rgb(200, 200, 200)); //1
            m_userColors.put(USERCOLOR9, FCColor.rgb(255, 255, 255)); //1
            m_userColors.put(USERCOLOR10, FCColor.rgb(43, 138, 195));
            m_userColors.put(USERCOLOR11, FCColor.rgba(0, 0, 0, 200)); //1
            m_userColors.put(USERCOLOR12, FCColor.rgb(255, 255, 255)); //1
            m_userColors.put(USERCOLOR13, FCColor.rgba(200, 200, 200, 240)); //1
            m_userColors.put(USERCOLOR14, FCColor.rgba(200, 200, 200, 100)); //1
            m_userColors.put(USERCOLOR15, FCColor.rgb(200, 200, 200)); //1
            m_userColors.put(USERCOLOR16, FCColor.rgb(200, 200, 200)); //1
            m_userColors.put(USERCOLOR17, FCColor.rgb(150, 150, 150)); //1
            m_userColors.put(USERCOLOR18, FCColor.rgba(0, 0, 0, 5)); //1
            m_userColors.put(USERCOLOR19, FCColor.rgba(0, 0, 0, 50)); //1
            m_userColors.put(USERCOLOR20, FCColor.rgb(50, 50, 50)); //1
            m_userColors.put(USERCOLOR21, FCColor.rgb(175, 175, 175)); //1
            m_userColors.put(USERCOLOR22, FCColor.rgb(0, 0, 0));
            m_userColors.put(USERCOLOR23, FCColor.rgba(43, 138, 195, 100));
            m_userColors.put(USERCOLOR24, FCColor.rgb(150, 150, 150)); //1
            m_userColors.put(USERCOLOR25, FCColor.rgb(255, 82, 82));
            m_userColors.put(USERCOLOR26, FCColor.rgb(50, 105, 217));
            m_userColors.put(USERCOLOR27, FCColor.rgb(0, 0, 0)); //1
            m_userColors.put(USERCOLOR28, FCColor.rgb(50, 50, 50)); //1
            m_userColors.put(USERCOLOR29, FCColor.rgb(175, 175, 175));
            m_userColors.put(USERCOLOR30, FCColor.rgb(225, 225, 225));
            m_userColors.put(USERCOLOR31, FCColor.rgb(255, 0, 0)); //1
            m_userColors.put(USERCOLOR32, FCColor.rgb(139, 180, 248));
            m_userColors.put(USERCOLOR33, FCColor.rgb(0, 165, 137));
            m_userColors.put(USERCOLOR34, FCColor.rgb(0, 0, 0));
            m_userColors.put(USERCOLOR35, FCColor.rgba(150, 150, 150, 200)); //1
            m_userColors.put(USERCOLOR36, FCColor.rgba(43, 138, 195, 200));
            m_userColors.put(USERCOLOR37, FCColor.rgb(255, 80, 80));
            m_userColors.put(USERCOLOR38, FCColor.rgba(43, 138, 195, 25));
            m_userColors.put(USERCOLOR39, FCColor.rgba(51, 153, 255, 75));
            m_userColors.put(USERCOLOR40, FCColor.rgb(0, 200, 0));
            m_userColors.put(USERCOLOR41, FCColor.rgba(255, 255, 255, 10)); //1
            m_userColors.put(USERCOLOR42, FCColor.rgba(200, 200, 200, 50)); //1
            m_userColors.put(USERCOLOR43, FCColor.rgb(0, 105, 217));
            m_userColors.put(USERCOLOR44, FCColor.rgba(0, 0, 0, 150)); //1
            m_userColors.put(USERCOLOR45, FCColor.rgba(255, 0, 0, 200));
            m_userColors.put(USERCOLOR46, FCColor.rgba(170, 178, 189, 50));
            m_userColors.put(USERCOLOR47, FCColor.rgba(170, 178, 189, 200));
            m_userColors.put(USERCOLOR48, FCColor.rgb(219, 68, 83));
            m_userColors.put(USERCOLOR49, FCColor.rgb(255, 80, 80));
            m_userColors.put(USERCOLOR50, FCColor.rgb(246, 187, 67));
            m_userColors.put(USERCOLOR51, FCColor.rgb(59, 174, 218));
            m_userColors.put(USERCOLOR52, FCColor.rgb(216, 112, 173));
            m_userColors.put(USERCOLOR53, FCColor.rgb(140, 192, 81));
            m_userColors.put(USERCOLOR54, FCColor.rgb(80, 255, 80));
            m_userColors.put(USERCOLOR55, FCColor.rgba(255, 80, 80, 200));
            m_userColors.put(USERCOLOR56, FCColor.rgba(200, 200, 200, 150)); //1
            m_userColors.put(USERCOLOR57, FCColor.rgba(0, 105, 217, 240));
            m_userColors.put(USERCOLOR58, FCColor.rgba(255, 255, 255, 25)); //1
            m_userColors.put(USERCOLOR59, FCColor.rgb(255, 215, 0));
            m_userColors.put(USERCOLOR60, FCColor.rgb(100, 100, 100)); //1
            m_userColors.put(USERCOLOR61, FCColor.rgba(255, 255, 255, 200)); //1
            m_userColors.put(USERCOLOR62, FCColor.rgba(43, 138, 195, 50));
            m_userColors.put(USERCOLOR63, FCColor.rgb(10, 36, 106));
            m_userColors.put(USERCOLOR64, FCColor.rgb(255, 255, 255)); //1
            m_userColors.put(USERCOLOR65, FCColor.rgba(255, 255, 255, 100)); //1
            m_userColors.put(USERCOLOR66, FCColor.rgba(255, 255, 255, 50)); //1
            m_userColors.put(USERCOLOR67, FCColor.rgb(20, 20, 20)); //1
            m_userColors.put(USERCOLOR68, FCColor.rgb(220, 220, 220)); //1
            m_userColors.put(USERCOLOR69, FCColor.rgb(248, 73, 96));
            m_userColors.put(USERCOLOR70, FCColor.rgb(15, 193, 118));
            m_userColors.put(USERCOLOR71, FCColor.rgba(248, 73, 96, 150));
            m_userColors.put(USERCOLOR72, FCColor.rgba(15, 193, 118, 150));
            m_userColors.put(USERCOLOR73, FCColor.rgb(130, 140, 150));
            m_userColors.put(USERCOLOR74, FCColor.rgba(94, 102, 115, 200));
            m_userColors.put(USERCOLOR75, FCColor.rgb(83, 195, 42));
            m_userColors.put(USERCOLOR76, FCColor.rgb(231, 192, 42));
            m_userColors.put(USERCOLOR77, FCColor.rgb(254, 89, 82));
            m_userColors.put(USERCOLOR78, FCColor.rgba(42, 138, 195, 100));
            m_userColors.put(USERCOLOR79, FCColor.rgb(200, 200, 200)); //1
            m_userColors.put(USERCOLOR80, FCColor.rgba(200, 200, 200, 150)); //1
            m_userColors.put(USERCOLOR81, FCColor.rgb(16, 95, 205));
            m_userColors.put(USERCOLOR82, FCColor.rgba(16, 95, 205, 100));
            m_userColors.put(USERCOLOR83, FCColor.rgb(150, 150, 150)); //1
            m_userColors.put(USERCOLOR84, FCColor.rgb(20, 20, 20)); //1
            m_userColors.put(USERCOLOR85, FCColor.rgb(70, 76, 79));
            m_userColors.put(USERCOLOR86, FCColor.rgb(200, 200, 200));
            m_userColors.put(USERCOLOR87, FCColor.rgb(210, 210, 210)); //1
            m_userColors.put(USERCOLOR88, FCColor.rgb(184, 185, 186));
            m_userColors.put(USERCOLOR89, FCColor.rgb(100, 100, 100)); //1
            m_userColors.put(USERCOLOR90, FCColor.rgb(255, 255, 80));
            m_userColors.put(USERCOLOR91, FCColor.rgba(42, 138, 195, 200));  //1
            m_userColors.put(USERCOLOR92, FCColor.rgba(220, 220, 220, 50));
            m_userColors.put(USERCOLOR93, FCColor.rgba(200, 200, 200, 25));
            m_userColors.put(USERCOLOR94, FCColor.rgb(220, 220, 220)); //1
            m_userColors.put(USERCOLOR95, FCColor.rgb(128, 128, 128));
            m_userColors.put(USERCOLOR96, FCColor.rgb(150, 0, 0));
            m_userColors.put(USERCOLOR97, FCColor.rgb(80, 255, 255));
            m_userColors.put(USERCOLOR98, FCColor.rgb(217, 217, 68));
            m_userColors.put(USERCOLOR99, FCColor.rgb(112, 112, 112));
            m_userColors.put(USERCOLOR100, FCColor.rgb(192, 192, 192));
            m_userColors.put(USERCOLOR101, FCColor.rgb(255, 255, 0));
            m_userColors.put(USERCOLOR102, FCColor.rgba(255, 255, 255, 200));
            m_userColors.put(USERCOLOR103, FCColor.rgba(43, 138, 195, 240));
            m_userColors.put(USERCOLOR104, FCColor.rgba(230, 230, 230, 240));
            m_userColors.put(USERCOLOR105, FCColor.rgba(0, 0, 0, 12)); //1
            m_userColors.put(USERCOLOR106, FCColor.rgb(222, 86, 122));
            m_userColors.put(USERCOLOR107, FCColor.rgb(115, 183, 72));
            m_userColors.put(USERCOLOR108, FCColor.rgba(219, 68, 83, 200));
            m_userColors.put(USERCOLOR109, FCColor.rgba(140, 192, 81, 200));
            m_userColors.put(USERCOLOR110, FCColor.rgb(15, 193, 118));
            m_userColors.put(USERCOLOR111, FCColor.rgba(220, 220, 220, 100));
            m_userColors.put(USERCOLOR112, FCColor.rgba(42, 138, 195, 230));
            m_userColors.put(USERCOLOR113, FCColor.rgba(15, 193, 118, 50));
            m_userColors.put(USERCOLOR114, FCColor.rgba(248, 73, 96, 50));
            m_userColors.put(USERCOLOR115, FCColor.rgba(170, 178, 189, 25));
            m_userColors.put(USERCOLOR116, FCColor.rgb(217, 218, 223));
            m_userColors.put(USERCOLOR117, FCColor.rgb(167, 171, 184));
            m_userColors.put(FCColor.Back, FCColor.rgb(255, 255, 255)); //1
            m_userColors.put(FCColor.Border, FCColor.rgb(200, 200, 200)); //1
            m_userColors.put(FCColor.Text, FCColor.rgb(0, 0, 0)); //1
            m_userColors.put(FCColor.DisabledBack, FCColor.rgba(0, 0, 0, 25)); //1
            m_userColors.put(FCColor.DisabledText, 3289650L);
            m_userColors.put(FCColor.Hovered, FCColor.rgba(43, 138, 195, 150));
            m_userColors.put(FCColor.Pushed, FCColor.rgba(43, 138, 195, 100));
        }
        else if (m_style == 2)
        {
            m_userColors.put(USERCOLOR, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR1, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR2, FCColor.rgba(255, 255, 255, 100));
            m_userColors.put(USERCOLOR3, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR4, FCColor.rgb(0, 0, 0));
            m_userColors.put(USERCOLOR5, FCColor.rgb(219, 68, 83)); //1
            m_userColors.put(USERCOLOR6, FCColor.rgba(255, 255, 255, 25));
            m_userColors.put(USERCOLOR7, FCColor.rgb(19, 21, 26));
            m_userColors.put(USERCOLOR8, FCColor.rgb(50, 50, 50));
            m_userColors.put(USERCOLOR9, FCColor.rgb(0, 0, 0));
            m_userColors.put(USERCOLOR10, FCColor.rgb(219, 68, 83)); //1
            m_userColors.put(USERCOLOR11, FCColor.rgba(255, 255, 255, 200));
            m_userColors.put(USERCOLOR12, FCColor.rgb(19, 21, 26));
            m_userColors.put(USERCOLOR13, FCColor.rgba(50, 50, 50, 240));
            m_userColors.put(USERCOLOR14, FCColor.rgba(50, 50, 50, 100));
            m_userColors.put(USERCOLOR15, FCColor.rgb(46, 47, 49));
            m_userColors.put(USERCOLOR16, FCColor.rgb(50, 50, 50));
            m_userColors.put(USERCOLOR17, FCColor.rgb(100, 100, 100));
            m_userColors.put(USERCOLOR18, FCColor.rgba(255, 255, 255, 5));
            m_userColors.put(USERCOLOR19, FCColor.rgba(255, 255, 255, 50));
            m_userColors.put(USERCOLOR20, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR21, FCColor.rgba(219, 68, 83, 100)); //1
            m_userColors.put(USERCOLOR22, FCColor.rgb(170, 178, 189));
            m_userColors.put(USERCOLOR23, FCColor.rgba(219, 68, 83, 100)); //1
            m_userColors.put(USERCOLOR24, FCColor.rgb(100, 100, 100));
            m_userColors.put(USERCOLOR25, FCColor.rgb(255, 82, 82));
            m_userColors.put(USERCOLOR26, FCColor.rgb(50, 105, 217));
            m_userColors.put(USERCOLOR27, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR28, FCColor.rgb(200, 200, 200));
            m_userColors.put(USERCOLOR29, FCColor.rgb(80, 80, 80));
            m_userColors.put(USERCOLOR30, FCColor.rgb(25, 25, 25));
            m_userColors.put(USERCOLOR31, FCColor.rgb(255, 0, 0));
            m_userColors.put(USERCOLOR32, FCColor.rgb(139, 180, 248));
            m_userColors.put(USERCOLOR33, FCColor.rgb(0, 165, 137));
            m_userColors.put(USERCOLOR34, FCColor.rgb(230, 230, 230));
            m_userColors.put(USERCOLOR35, FCColor.rgba(100, 100, 100, 200));
            m_userColors.put(USERCOLOR36, FCColor.rgba(219, 68, 83, 200)); //1
            m_userColors.put(USERCOLOR37, FCColor.rgb(255, 80, 80));
            m_userColors.put(USERCOLOR38, FCColor.rgba(43, 138, 195, 25));
            m_userColors.put(USERCOLOR39, FCColor.rgba(51, 153, 255, 75));
            m_userColors.put(USERCOLOR40, FCColor.rgb(0, 200, 0));
            m_userColors.put(USERCOLOR41, FCColor.rgba(0, 0, 0, 10));
            m_userColors.put(USERCOLOR42, FCColor.rgba(50, 50, 50, 50));
            m_userColors.put(USERCOLOR43, FCColor.rgb(0, 105, 217));
            m_userColors.put(USERCOLOR44, FCColor.rgba(255, 255, 255, 150));
            m_userColors.put(USERCOLOR45, FCColor.rgba(255, 0, 0, 200));
            m_userColors.put(USERCOLOR46, FCColor.rgba(170, 178, 189, 50));
            m_userColors.put(USERCOLOR47, FCColor.rgba(170, 178, 189, 200));
            m_userColors.put(USERCOLOR48, FCColor.rgb(219, 68, 83));
            m_userColors.put(USERCOLOR49, FCColor.rgb(255, 80, 80));
            m_userColors.put(USERCOLOR50, FCColor.rgb(246, 187, 67));
            m_userColors.put(USERCOLOR51, FCColor.rgb(59, 174, 218));
            m_userColors.put(USERCOLOR52, FCColor.rgb(216, 112, 173));
            m_userColors.put(USERCOLOR53, FCColor.rgb(140, 192, 81));
            m_userColors.put(USERCOLOR54, FCColor.rgb(80, 255, 80));
            m_userColors.put(USERCOLOR55, FCColor.rgba(255, 80, 80, 200));
            m_userColors.put(USERCOLOR56, FCColor.rgba(50, 50, 50, 150));
            m_userColors.put(USERCOLOR57, FCColor.rgba(0, 105, 217, 240));
            m_userColors.put(USERCOLOR58, FCColor.rgba(0, 0, 0, 25));
            m_userColors.put(USERCOLOR59, FCColor.rgb(255, 215, 0));
            m_userColors.put(USERCOLOR60, FCColor.rgb(150, 150, 150));
            m_userColors.put(USERCOLOR61, FCColor.rgba(0, 0, 0, 200));
            m_userColors.put(USERCOLOR62, FCColor.rgba(219, 68, 83, 50)); //1
            m_userColors.put(USERCOLOR63, FCColor.rgb(10, 36, 106));
            m_userColors.put(USERCOLOR64, FCColor.rgb(21, 24, 28));
            m_userColors.put(USERCOLOR65, FCColor.rgba(0, 0, 0, 100));
            m_userColors.put(USERCOLOR66, FCColor.rgba(0, 0, 0, 50));
            m_userColors.put(USERCOLOR67, FCColor.rgb(230, 230, 230));
            m_userColors.put(USERCOLOR68, FCColor.rgba(219, 68, 83, 200)); //1
            m_userColors.put(USERCOLOR69, FCColor.rgb(248, 73, 96));
            m_userColors.put(USERCOLOR70, FCColor.rgb(15, 193, 118));
            m_userColors.put(USERCOLOR71, FCColor.rgba(248, 73, 96, 150));
            m_userColors.put(USERCOLOR72, FCColor.rgba(15, 193, 118, 150));
            m_userColors.put(USERCOLOR73, FCColor.rgb(130, 140, 150));
            m_userColors.put(USERCOLOR74, FCColor.rgba(219, 68, 83, 200)); //1
            m_userColors.put(USERCOLOR75, FCColor.rgb(83, 195, 42));
            m_userColors.put(USERCOLOR76, FCColor.rgb(231, 192, 42));
            m_userColors.put(USERCOLOR77, FCColor.rgb(254, 89, 82));
            m_userColors.put(USERCOLOR78, FCColor.rgba(42, 138, 195, 100));
            m_userColors.put(USERCOLOR79, FCColor.rgb(219, 68, 83));; //1
            m_userColors.put(USERCOLOR80, FCColor.rgba(52, 53, 58, 150));
            m_userColors.put(USERCOLOR81, FCColor.rgb(219, 68, 83)); //1
            m_userColors.put(USERCOLOR82, FCColor.rgba(16, 95, 205, 100));
            m_userColors.put(USERCOLOR83, FCColor.rgb(107, 107, 107));
            m_userColors.put(USERCOLOR84, FCColor.rgb(233, 233, 233));
            m_userColors.put(USERCOLOR85, FCColor.rgb(70, 76, 79));
            m_userColors.put(USERCOLOR86, FCColor.rgba(219, 68, 83, 100)); //1
            m_userColors.put(USERCOLOR87, FCColor.rgb(39, 41, 46));
            m_userColors.put(USERCOLOR88, FCColor.rgb(184, 185, 186));
            m_userColors.put(USERCOLOR89, FCColor.rgb(150, 150, 150));
            m_userColors.put(USERCOLOR90, FCColor.rgb(255, 255, 80));
            m_userColors.put(USERCOLOR91, FCColor.rgba(219, 68, 83, 200)); //1
            m_userColors.put(USERCOLOR92, FCColor.rgba(219, 68, 83, 50));//1
            m_userColors.put(USERCOLOR93, FCColor.rgba(50, 50, 50, 25));
            m_userColors.put(USERCOLOR94, FCColor.rgba(219, 68, 83, 200)); //1
            m_userColors.put(USERCOLOR95, FCColor.rgba(219, 68, 83, 100)); //1
            m_userColors.put(USERCOLOR96, FCColor.rgb(150, 0, 0));
            m_userColors.put(USERCOLOR97, FCColor.rgb(80, 255, 255));
            m_userColors.put(USERCOLOR98, FCColor.rgb(217, 217, 68));
            m_userColors.put(USERCOLOR99, FCColor.rgb(112, 112, 112));
            m_userColors.put(USERCOLOR100, FCColor.rgb(192, 192, 192));
            m_userColors.put(USERCOLOR101, FCColor.rgb(255, 255, 0));
            m_userColors.put(USERCOLOR102, FCColor.rgba(0, 0, 0, 200));
            m_userColors.put(USERCOLOR103, FCColor.rgba(43, 138, 195, 240));
            m_userColors.put(USERCOLOR104, FCColor.rgba(21, 24, 28, 240));
            m_userColors.put(USERCOLOR105, FCColor.rgba(255, 255, 255, 12));
            m_userColors.put(USERCOLOR106, FCColor.rgb(222, 86, 122));
            m_userColors.put(USERCOLOR107, FCColor.rgb(115, 183, 72));
            m_userColors.put(USERCOLOR108, FCColor.rgba(219, 68, 83, 200));
            m_userColors.put(USERCOLOR109, FCColor.rgba(140, 192, 81, 200));
            m_userColors.put(USERCOLOR110, FCColor.rgb(219, 68, 83));
            m_userColors.put(USERCOLOR111, FCColor.rgba(32, 36, 38, 100));
            m_userColors.put(USERCOLOR112, FCColor.rgba(42, 138, 195, 230));
            m_userColors.put(USERCOLOR113, FCColor.rgba(15, 193, 118, 50));
            m_userColors.put(USERCOLOR114, FCColor.rgba(248, 73, 96, 50));
            m_userColors.put(USERCOLOR115, FCColor.rgba(170, 178, 189, 25));
            m_userColors.put(USERCOLOR116, FCColor.rgb(217, 218, 223));
            m_userColors.put(USERCOLOR117, FCColor.rgb(167, 171, 184));
            m_userColors.put(FCColor.Back, FCColor.rgb(19, 21, 26));
            m_userColors.put(FCColor.Border, FCColor.rgb(50, 50, 50));
            m_userColors.put(FCColor.Text, FCColor.rgb(255, 255, 255));
            m_userColors.put(FCColor.DisabledBack, FCColor.rgba(255, 255, 255, 25));
            m_userColors.put(FCColor.DisabledText, 3289650L);
            m_userColors.put(FCColor.Hovered, FCColor.rgba(219, 68, 83, 150)); //1
            m_userColors.put(FCColor.Pushed, FCColor.rgba(219, 68, 83, 100)); //1
        }
        else if (m_style == 3)
        {
            m_userColors.put(USERCOLOR, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR1, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR2, FCColor.rgba(255, 255, 255, 100));
            m_userColors.put(USERCOLOR3, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR4, FCColor.rgb(0, 0, 0));
            m_userColors.put(USERCOLOR5, FCColor.rgb(15, 193, 118)); //1
            m_userColors.put(USERCOLOR6, FCColor.rgba(255, 255, 255, 25));
            m_userColors.put(USERCOLOR7, FCColor.rgb(19, 21, 26));
            m_userColors.put(USERCOLOR8, FCColor.rgb(50, 50, 50));
            m_userColors.put(USERCOLOR9, FCColor.rgb(0, 0, 0));
            m_userColors.put(USERCOLOR10, FCColor.rgb(15, 193, 118)); //1
            m_userColors.put(USERCOLOR11, FCColor.rgba(255, 255, 255, 200));
            m_userColors.put(USERCOLOR12, FCColor.rgb(19, 21, 26));
            m_userColors.put(USERCOLOR13, FCColor.rgba(50, 50, 50, 240));
            m_userColors.put(USERCOLOR14, FCColor.rgba(50, 50, 50, 100));
            m_userColors.put(USERCOLOR15, FCColor.rgb(46, 47, 49));
            m_userColors.put(USERCOLOR16, FCColor.rgb(50, 50, 50));
            m_userColors.put(USERCOLOR17, FCColor.rgb(100, 100, 100));
            m_userColors.put(USERCOLOR18, FCColor.rgba(255, 255, 255, 5));
            m_userColors.put(USERCOLOR19, FCColor.rgba(255, 255, 255, 50));
            m_userColors.put(USERCOLOR20, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR21, FCColor.rgba(15, 193, 118, 100)); //1
            m_userColors.put(USERCOLOR22, FCColor.rgb(170, 178, 189));
            m_userColors.put(USERCOLOR23, FCColor.rgba(15, 193, 118, 100)); //1
            m_userColors.put(USERCOLOR24, FCColor.rgb(100, 100, 100));
            m_userColors.put(USERCOLOR25, FCColor.rgb(255, 82, 82));
            m_userColors.put(USERCOLOR26, FCColor.rgb(50, 105, 217));
            m_userColors.put(USERCOLOR27, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR28, FCColor.rgb(200, 200, 200));
            m_userColors.put(USERCOLOR29, FCColor.rgb(80, 80, 80));
            m_userColors.put(USERCOLOR30, FCColor.rgb(25, 25, 25));
            m_userColors.put(USERCOLOR31, FCColor.rgb(255, 0, 0));
            m_userColors.put(USERCOLOR32, FCColor.rgb(139, 180, 248));
            m_userColors.put(USERCOLOR33, FCColor.rgb(0, 165, 137));
            m_userColors.put(USERCOLOR34, FCColor.rgb(230, 230, 230));
            m_userColors.put(USERCOLOR35, FCColor.rgba(100, 100, 100, 200));
            m_userColors.put(USERCOLOR36, FCColor.rgba(15, 193, 118, 200)); //1
            m_userColors.put(USERCOLOR37, FCColor.rgb(255, 80, 80));
            m_userColors.put(USERCOLOR38, FCColor.rgba(43, 138, 195, 25));
            m_userColors.put(USERCOLOR39, FCColor.rgba(51, 153, 255, 75));
            m_userColors.put(USERCOLOR40, FCColor.rgb(0, 200, 0));
            m_userColors.put(USERCOLOR41, FCColor.rgba(0, 0, 0, 10));
            m_userColors.put(USERCOLOR42, FCColor.rgba(50, 50, 50, 50));
            m_userColors.put(USERCOLOR43, FCColor.rgb(0, 105, 217));
            m_userColors.put(USERCOLOR44, FCColor.rgba(255, 255, 255, 150));
            m_userColors.put(USERCOLOR45, FCColor.rgba(255, 0, 0, 200));
            m_userColors.put(USERCOLOR46, FCColor.rgba(170, 178, 189, 50));
            m_userColors.put(USERCOLOR47, FCColor.rgba(170, 178, 189, 200));
            m_userColors.put(USERCOLOR48, FCColor.rgb(219, 68, 83));
            m_userColors.put(USERCOLOR49, FCColor.rgb(255, 80, 80));
            m_userColors.put(USERCOLOR50, FCColor.rgb(246, 187, 67));
            m_userColors.put(USERCOLOR51, FCColor.rgb(59, 174, 218));
            m_userColors.put(USERCOLOR52, FCColor.rgb(216, 112, 173));
            m_userColors.put(USERCOLOR53, FCColor.rgb(140, 192, 81));
            m_userColors.put(USERCOLOR54, FCColor.rgb(80, 255, 80));
            m_userColors.put(USERCOLOR55, FCColor.rgba(255, 80, 80, 200));
            m_userColors.put(USERCOLOR56, FCColor.rgba(50, 50, 50, 150));
            m_userColors.put(USERCOLOR57, FCColor.rgba(0, 105, 217, 240));
            m_userColors.put(USERCOLOR58, FCColor.rgba(0, 0, 0, 25));
            m_userColors.put(USERCOLOR59, FCColor.rgb(255, 215, 0));
            m_userColors.put(USERCOLOR60, FCColor.rgb(150, 150, 150));
            m_userColors.put(USERCOLOR61, FCColor.rgba(0, 0, 0, 200));
            m_userColors.put(USERCOLOR62, FCColor.rgba(15, 193, 118, 50)); //1
            m_userColors.put(USERCOLOR63, FCColor.rgb(10, 36, 106));
            m_userColors.put(USERCOLOR64, FCColor.rgb(21, 24, 28));
            m_userColors.put(USERCOLOR65, FCColor.rgba(0, 0, 0, 100));
            m_userColors.put(USERCOLOR66, FCColor.rgba(0, 0, 0, 50));
            m_userColors.put(USERCOLOR67, FCColor.rgb(230, 230, 230));
            m_userColors.put(USERCOLOR68, FCColor.rgba(15, 193, 118, 200)); //1
            m_userColors.put(USERCOLOR69, FCColor.rgb(248, 73, 96));
            m_userColors.put(USERCOLOR70, FCColor.rgb(15, 193, 118));
            m_userColors.put(USERCOLOR71, FCColor.rgba(248, 73, 96, 150));
            m_userColors.put(USERCOLOR72, FCColor.rgba(15, 193, 118, 150));
            m_userColors.put(USERCOLOR73, FCColor.rgb(130, 140, 150));
            m_userColors.put(USERCOLOR74, FCColor.rgba(15, 193, 118, 200)); //1
            m_userColors.put(USERCOLOR75, FCColor.rgb(83, 195, 42));
            m_userColors.put(USERCOLOR76, FCColor.rgb(231, 192, 42));
            m_userColors.put(USERCOLOR77, FCColor.rgb(254, 89, 82));
            m_userColors.put(USERCOLOR78, FCColor.rgba(42, 138, 195, 100));
            m_userColors.put(USERCOLOR79, FCColor.rgb(15, 193, 118));; //1
            m_userColors.put(USERCOLOR80, FCColor.rgba(52, 53, 58, 150));
            m_userColors.put(USERCOLOR81, FCColor.rgb(15, 193, 118)); //1
            m_userColors.put(USERCOLOR82, FCColor.rgba(16, 95, 205, 100));
            m_userColors.put(USERCOLOR83, FCColor.rgb(107, 107, 107));
            m_userColors.put(USERCOLOR84, FCColor.rgb(233, 233, 233));
            m_userColors.put(USERCOLOR85, FCColor.rgb(70, 76, 79));
            m_userColors.put(USERCOLOR86, FCColor.rgba(15, 193, 118, 100)); //1
            m_userColors.put(USERCOLOR87, FCColor.rgb(39, 41, 46));
            m_userColors.put(USERCOLOR88, FCColor.rgb(184, 185, 186));
            m_userColors.put(USERCOLOR89, FCColor.rgb(150, 150, 150));
            m_userColors.put(USERCOLOR90, FCColor.rgb(255, 255, 80));
            m_userColors.put(USERCOLOR91, FCColor.rgba(15, 193, 118, 200)); //1
            m_userColors.put(USERCOLOR92, FCColor.rgba(15, 193, 118, 50));//1
            m_userColors.put(USERCOLOR93, FCColor.rgba(50, 50, 50, 25));
            m_userColors.put(USERCOLOR94, FCColor.rgba(15, 193, 118, 200)); //1
            m_userColors.put(USERCOLOR95, FCColor.rgba(15, 193, 118, 100)); //1
            m_userColors.put(USERCOLOR96, FCColor.rgb(150, 0, 0));
            m_userColors.put(USERCOLOR97, FCColor.rgb(80, 255, 255));
            m_userColors.put(USERCOLOR98, FCColor.rgb(217, 217, 68));
            m_userColors.put(USERCOLOR99, FCColor.rgb(112, 112, 112));
            m_userColors.put(USERCOLOR100, FCColor.rgb(192, 192, 192));
            m_userColors.put(USERCOLOR101, FCColor.rgb(255, 255, 0));
            m_userColors.put(USERCOLOR102, FCColor.rgba(0, 0, 0, 200));
            m_userColors.put(USERCOLOR103, FCColor.rgba(43, 138, 195, 240));
            m_userColors.put(USERCOLOR104, FCColor.rgba(21, 24, 28, 240));
            m_userColors.put(USERCOLOR105, FCColor.rgba(255, 255, 255, 12));
            m_userColors.put(USERCOLOR106, FCColor.rgb(222, 86, 122));
            m_userColors.put(USERCOLOR107, FCColor.rgb(115, 183, 72));
            m_userColors.put(USERCOLOR108, FCColor.rgba(219, 68, 83, 200));
            m_userColors.put(USERCOLOR109, FCColor.rgba(140, 192, 81, 200));
            m_userColors.put(USERCOLOR110, FCColor.rgb(15, 193, 118));
            m_userColors.put(USERCOLOR111, FCColor.rgba(32, 36, 38, 100));
            m_userColors.put(USERCOLOR112, FCColor.rgba(42, 138, 195, 230));
            m_userColors.put(USERCOLOR113, FCColor.rgba(15, 193, 118, 50));
            m_userColors.put(USERCOLOR114, FCColor.rgba(248, 73, 96, 50));
            m_userColors.put(USERCOLOR115, FCColor.rgba(170, 178, 189, 25));
            m_userColors.put(USERCOLOR116, FCColor.rgb(217, 218, 223));
            m_userColors.put(USERCOLOR117, FCColor.rgb(167, 171, 184));
            m_userColors.put(FCColor.Back, FCColor.rgb(19, 21, 26));
            m_userColors.put(FCColor.Border, FCColor.rgb(50, 50, 50));
            m_userColors.put(FCColor.Text, FCColor.rgb(255, 255, 255));
            m_userColors.put(FCColor.DisabledBack, FCColor.rgba(255, 255, 255, 25));
            m_userColors.put(FCColor.DisabledText, 3289650L);
            m_userColors.put(FCColor.Hovered, FCColor.rgba(15, 193, 118, 150)); //1
            m_userColors.put(FCColor.Pushed, FCColor.rgba(15, 193, 118, 100)); //1
        }
        else if (m_style == 4)
        {
            m_userColors.put(USERCOLOR, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR1, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR2, FCColor.rgba(255, 255, 255, 100));
            m_userColors.put(USERCOLOR3, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR4, FCColor.rgb(0, 0, 0));
            m_userColors.put(USERCOLOR5, FCColor.rgb(185, 63, 150)); //1
            m_userColors.put(USERCOLOR6, FCColor.rgba(255, 255, 255, 25));
            m_userColors.put(USERCOLOR7, FCColor.rgb(19, 21, 26));
            m_userColors.put(USERCOLOR8, FCColor.rgb(50, 50, 50));
            m_userColors.put(USERCOLOR9, FCColor.rgb(0, 0, 0));
            m_userColors.put(USERCOLOR10, FCColor.rgb(185, 63, 150)); //1
            m_userColors.put(USERCOLOR11, FCColor.rgba(255, 255, 255, 200));
            m_userColors.put(USERCOLOR12, FCColor.rgb(19, 21, 26));
            m_userColors.put(USERCOLOR13, FCColor.rgba(50, 50, 50, 240));
            m_userColors.put(USERCOLOR14, FCColor.rgba(50, 50, 50, 100));
            m_userColors.put(USERCOLOR15, FCColor.rgb(46, 47, 49));
            m_userColors.put(USERCOLOR16, FCColor.rgb(50, 50, 50));
            m_userColors.put(USERCOLOR17, FCColor.rgb(100, 100, 100));
            m_userColors.put(USERCOLOR18, FCColor.rgba(255, 255, 255, 5));
            m_userColors.put(USERCOLOR19, FCColor.rgba(255, 255, 255, 50));
            m_userColors.put(USERCOLOR20, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR21, FCColor.rgba(185, 63, 150, 100)); //1
            m_userColors.put(USERCOLOR22, FCColor.rgb(170, 178, 189));
            m_userColors.put(USERCOLOR23, FCColor.rgba(185, 63, 150, 100)); //1
            m_userColors.put(USERCOLOR24, FCColor.rgb(100, 100, 100));
            m_userColors.put(USERCOLOR25, FCColor.rgb(255, 82, 82));
            m_userColors.put(USERCOLOR26, FCColor.rgb(50, 105, 217));
            m_userColors.put(USERCOLOR27, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR28, FCColor.rgb(200, 200, 200));
            m_userColors.put(USERCOLOR29, FCColor.rgb(80, 80, 80));
            m_userColors.put(USERCOLOR30, FCColor.rgb(25, 25, 25));
            m_userColors.put(USERCOLOR31, FCColor.rgb(255, 0, 0));
            m_userColors.put(USERCOLOR32, FCColor.rgb(139, 180, 248));
            m_userColors.put(USERCOLOR33, FCColor.rgb(0, 165, 137));
            m_userColors.put(USERCOLOR34, FCColor.rgb(230, 230, 230));
            m_userColors.put(USERCOLOR35, FCColor.rgba(100, 100, 100, 200));
            m_userColors.put(USERCOLOR36, FCColor.rgba(185, 63, 150, 200)); //1
            m_userColors.put(USERCOLOR37, FCColor.rgb(255, 80, 80));
            m_userColors.put(USERCOLOR38, FCColor.rgba(43, 138, 195, 25));
            m_userColors.put(USERCOLOR39, FCColor.rgba(51, 153, 255, 75));
            m_userColors.put(USERCOLOR40, FCColor.rgb(0, 200, 0));
            m_userColors.put(USERCOLOR41, FCColor.rgba(0, 0, 0, 10));
            m_userColors.put(USERCOLOR42, FCColor.rgba(50, 50, 50, 50));
            m_userColors.put(USERCOLOR43, FCColor.rgb(0, 105, 217));
            m_userColors.put(USERCOLOR44, FCColor.rgba(255, 255, 255, 150));
            m_userColors.put(USERCOLOR45, FCColor.rgba(255, 0, 0, 200));
            m_userColors.put(USERCOLOR46, FCColor.rgba(170, 178, 189, 50));
            m_userColors.put(USERCOLOR47, FCColor.rgba(170, 178, 189, 200));
            m_userColors.put(USERCOLOR48, FCColor.rgb(219, 68, 83));
            m_userColors.put(USERCOLOR49, FCColor.rgb(255, 80, 80));
            m_userColors.put(USERCOLOR50, FCColor.rgb(246, 187, 67));
            m_userColors.put(USERCOLOR51, FCColor.rgb(59, 174, 218));
            m_userColors.put(USERCOLOR52, FCColor.rgb(216, 112, 173));
            m_userColors.put(USERCOLOR53, FCColor.rgb(140, 192, 81));
            m_userColors.put(USERCOLOR54, FCColor.rgb(80, 255, 80));
            m_userColors.put(USERCOLOR55, FCColor.rgba(255, 80, 80, 200));
            m_userColors.put(USERCOLOR56, FCColor.rgba(50, 50, 50, 150));
            m_userColors.put(USERCOLOR57, FCColor.rgba(0, 105, 217, 240));
            m_userColors.put(USERCOLOR58, FCColor.rgba(0, 0, 0, 25));
            m_userColors.put(USERCOLOR59, FCColor.rgb(255, 215, 0));
            m_userColors.put(USERCOLOR60, FCColor.rgb(150, 150, 150));
            m_userColors.put(USERCOLOR61, FCColor.rgba(0, 0, 0, 200));
            m_userColors.put(USERCOLOR62, FCColor.rgba(185, 63, 150, 50)); //1
            m_userColors.put(USERCOLOR63, FCColor.rgb(10, 36, 106));
            m_userColors.put(USERCOLOR64, FCColor.rgb(21, 24, 28));
            m_userColors.put(USERCOLOR65, FCColor.rgba(0, 0, 0, 100));
            m_userColors.put(USERCOLOR66, FCColor.rgba(0, 0, 0, 50));
            m_userColors.put(USERCOLOR67, FCColor.rgb(230, 230, 230));
            m_userColors.put(USERCOLOR68, FCColor.rgba(185, 63, 150, 200)); //1
            m_userColors.put(USERCOLOR69, FCColor.rgb(248, 73, 96));
            m_userColors.put(USERCOLOR70, FCColor.rgb(15, 193, 118));
            m_userColors.put(USERCOLOR71, FCColor.rgba(248, 73, 96, 150));
            m_userColors.put(USERCOLOR72, FCColor.rgba(15, 193, 118, 150));
            m_userColors.put(USERCOLOR73, FCColor.rgb(130, 140, 150));
            m_userColors.put(USERCOLOR74, FCColor.rgba(185, 63, 150, 200)); //1
            m_userColors.put(USERCOLOR75, FCColor.rgb(83, 195, 42));
            m_userColors.put(USERCOLOR76, FCColor.rgb(231, 192, 42));
            m_userColors.put(USERCOLOR77, FCColor.rgb(254, 89, 82));
            m_userColors.put(USERCOLOR78, FCColor.rgba(42, 138, 195, 100));
            m_userColors.put(USERCOLOR79, FCColor.rgb(185, 63, 150));; //1
            m_userColors.put(USERCOLOR80, FCColor.rgba(52, 53, 58, 150));
            m_userColors.put(USERCOLOR81, FCColor.rgb(185, 63, 150)); //1
            m_userColors.put(USERCOLOR82, FCColor.rgba(16, 95, 205, 100));
            m_userColors.put(USERCOLOR83, FCColor.rgb(107, 107, 107));
            m_userColors.put(USERCOLOR84, FCColor.rgb(233, 233, 233));
            m_userColors.put(USERCOLOR85, FCColor.rgb(70, 76, 79));
            m_userColors.put(USERCOLOR86, FCColor.rgba(185, 63, 150, 100)); //1
            m_userColors.put(USERCOLOR87, FCColor.rgb(39, 41, 46));
            m_userColors.put(USERCOLOR88, FCColor.rgb(184, 185, 186));
            m_userColors.put(USERCOLOR89, FCColor.rgb(150, 150, 150));
            m_userColors.put(USERCOLOR90, FCColor.rgb(255, 255, 80));
            m_userColors.put(USERCOLOR91, FCColor.rgba(185, 63, 150, 200)); //1
            m_userColors.put(USERCOLOR92, FCColor.rgba(185, 63, 150, 50));//1
            m_userColors.put(USERCOLOR93, FCColor.rgba(50, 50, 50, 25));
            m_userColors.put(USERCOLOR94, FCColor.rgba(185, 63, 150, 200)); //1
            m_userColors.put(USERCOLOR95, FCColor.rgba(185, 63, 150, 100)); //1
            m_userColors.put(USERCOLOR96, FCColor.rgb(150, 0, 0));
            m_userColors.put(USERCOLOR97, FCColor.rgb(80, 255, 255));
            m_userColors.put(USERCOLOR98, FCColor.rgb(217, 217, 68));
            m_userColors.put(USERCOLOR99, FCColor.rgb(112, 112, 112));
            m_userColors.put(USERCOLOR100, FCColor.rgb(192, 192, 192));
            m_userColors.put(USERCOLOR101, FCColor.rgb(255, 255, 0));
            m_userColors.put(USERCOLOR102, FCColor.rgba(0, 0, 0, 200));
            m_userColors.put(USERCOLOR103, FCColor.rgba(43, 138, 195, 240));
            m_userColors.put(USERCOLOR104, FCColor.rgba(21, 24, 28, 240));
            m_userColors.put(USERCOLOR105, FCColor.rgba(255, 255, 255, 12));
            m_userColors.put(USERCOLOR106, FCColor.rgb(222, 86, 122));
            m_userColors.put(USERCOLOR107, FCColor.rgb(115, 183, 72));
            m_userColors.put(USERCOLOR108, FCColor.rgba(219, 68, 83, 200));
            m_userColors.put(USERCOLOR109, FCColor.rgba(140, 192, 81, 200));
            m_userColors.put(USERCOLOR110, FCColor.rgb(216, 112, 173));
            m_userColors.put(USERCOLOR111, FCColor.rgba(32, 36, 38, 100));
            m_userColors.put(USERCOLOR112, FCColor.rgba(42, 138, 195, 230));
            m_userColors.put(USERCOLOR113, FCColor.rgba(15, 193, 118, 50));
            m_userColors.put(USERCOLOR114, FCColor.rgba(248, 73, 96, 50));
            m_userColors.put(USERCOLOR115, FCColor.rgba(170, 178, 189, 25));
            m_userColors.put(USERCOLOR116, FCColor.rgb(217, 218, 223));
            m_userColors.put(USERCOLOR117, FCColor.rgb(167, 171, 184));
            m_userColors.put(FCColor.Back, FCColor.rgb(19, 21, 26));
            m_userColors.put(FCColor.Border, FCColor.rgb(50, 50, 50));
            m_userColors.put(FCColor.Text, FCColor.rgb(255, 255, 255));
            m_userColors.put(FCColor.DisabledBack, FCColor.rgba(255, 255, 255, 25));
            m_userColors.put(FCColor.DisabledText, 3289650L);
            m_userColors.put(FCColor.Hovered, FCColor.rgba(185, 63, 150, 150)); //1
            m_userColors.put(FCColor.Pushed, FCColor.rgba(185, 63, 150, 100)); //1
        }
        else if (m_style == 5)
        {
            m_userColors.put(USERCOLOR, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR1, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR2, FCColor.rgba(255, 255, 255, 100));
            m_userColors.put(USERCOLOR3, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR4, FCColor.rgb(0, 0, 0));
            m_userColors.put(USERCOLOR5, FCColor.rgb(75, 137, 220)); //1
            m_userColors.put(USERCOLOR6, FCColor.rgba(255, 255, 255, 25));
            m_userColors.put(USERCOLOR7, FCColor.rgb(19, 21, 26));
            m_userColors.put(USERCOLOR8, FCColor.rgb(50, 50, 50));
            m_userColors.put(USERCOLOR9, FCColor.rgb(0, 0, 0));
            m_userColors.put(USERCOLOR10, FCColor.rgb(75, 137, 220)); //1
            m_userColors.put(USERCOLOR11, FCColor.rgba(255, 255, 255, 200));
            m_userColors.put(USERCOLOR12, FCColor.rgb(19, 21, 26));
            m_userColors.put(USERCOLOR13, FCColor.rgba(50, 50, 50, 240));
            m_userColors.put(USERCOLOR14, FCColor.rgba(50, 50, 50, 100));
            m_userColors.put(USERCOLOR15, FCColor.rgb(46, 47, 49));
            m_userColors.put(USERCOLOR16, FCColor.rgb(50, 50, 50));
            m_userColors.put(USERCOLOR17, FCColor.rgb(100, 100, 100));
            m_userColors.put(USERCOLOR18, FCColor.rgba(255, 255, 255, 5));
            m_userColors.put(USERCOLOR19, FCColor.rgba(255, 255, 255, 50));
            m_userColors.put(USERCOLOR20, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR21, FCColor.rgba(75, 137, 220, 100)); //1
            m_userColors.put(USERCOLOR22, FCColor.rgb(170, 178, 189));
            m_userColors.put(USERCOLOR23, FCColor.rgba(75, 137, 220, 100)); //1
            m_userColors.put(USERCOLOR24, FCColor.rgb(100, 100, 100));
            m_userColors.put(USERCOLOR25, FCColor.rgb(255, 82, 82));
            m_userColors.put(USERCOLOR26, FCColor.rgb(50, 105, 217));
            m_userColors.put(USERCOLOR27, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR28, FCColor.rgb(200, 200, 200));
            m_userColors.put(USERCOLOR29, FCColor.rgb(80, 80, 80));
            m_userColors.put(USERCOLOR30, FCColor.rgb(25, 25, 25));
            m_userColors.put(USERCOLOR31, FCColor.rgb(255, 0, 0));
            m_userColors.put(USERCOLOR32, FCColor.rgb(139, 180, 248));
            m_userColors.put(USERCOLOR33, FCColor.rgb(0, 165, 137));
            m_userColors.put(USERCOLOR34, FCColor.rgb(230, 230, 230));
            m_userColors.put(USERCOLOR35, FCColor.rgba(100, 100, 100, 200));
            m_userColors.put(USERCOLOR36, FCColor.rgba(75, 137, 220, 200)); //1
            m_userColors.put(USERCOLOR37, FCColor.rgb(255, 80, 80));
            m_userColors.put(USERCOLOR38, FCColor.rgba(43, 138, 195, 25));
            m_userColors.put(USERCOLOR39, FCColor.rgba(51, 153, 255, 75));
            m_userColors.put(USERCOLOR40, FCColor.rgb(0, 200, 0));
            m_userColors.put(USERCOLOR41, FCColor.rgba(0, 0, 0, 10));
            m_userColors.put(USERCOLOR42, FCColor.rgba(50, 50, 50, 50));
            m_userColors.put(USERCOLOR43, FCColor.rgb(0, 105, 217));
            m_userColors.put(USERCOLOR44, FCColor.rgba(255, 255, 255, 150));
            m_userColors.put(USERCOLOR45, FCColor.rgba(255, 0, 0, 200));
            m_userColors.put(USERCOLOR46, FCColor.rgba(170, 178, 189, 50));
            m_userColors.put(USERCOLOR47, FCColor.rgba(170, 178, 189, 200));
            m_userColors.put(USERCOLOR48, FCColor.rgb(219, 68, 83));
            m_userColors.put(USERCOLOR49, FCColor.rgb(255, 80, 80));
            m_userColors.put(USERCOLOR50, FCColor.rgb(246, 187, 67));
            m_userColors.put(USERCOLOR51, FCColor.rgb(59, 174, 218));
            m_userColors.put(USERCOLOR52, FCColor.rgb(216, 112, 173));
            m_userColors.put(USERCOLOR53, FCColor.rgb(140, 192, 81));
            m_userColors.put(USERCOLOR54, FCColor.rgb(80, 255, 80));
            m_userColors.put(USERCOLOR55, FCColor.rgba(255, 80, 80, 200));
            m_userColors.put(USERCOLOR56, FCColor.rgba(50, 50, 50, 150));
            m_userColors.put(USERCOLOR57, FCColor.rgba(0, 105, 217, 240));
            m_userColors.put(USERCOLOR58, FCColor.rgba(0, 0, 0, 25));
            m_userColors.put(USERCOLOR59, FCColor.rgb(255, 215, 0));
            m_userColors.put(USERCOLOR60, FCColor.rgb(150, 150, 150));
            m_userColors.put(USERCOLOR61, FCColor.rgba(0, 0, 0, 200));
            m_userColors.put(USERCOLOR62, FCColor.rgba(75, 137, 220, 50)); //1
            m_userColors.put(USERCOLOR63, FCColor.rgb(10, 36, 106));
            m_userColors.put(USERCOLOR64, FCColor.rgb(21, 24, 28));
            m_userColors.put(USERCOLOR65, FCColor.rgba(0, 0, 0, 100));
            m_userColors.put(USERCOLOR66, FCColor.rgba(0, 0, 0, 50));
            m_userColors.put(USERCOLOR67, FCColor.rgb(230, 230, 230));
            m_userColors.put(USERCOLOR68, FCColor.rgba(75, 137, 220, 200)); //1
            m_userColors.put(USERCOLOR69, FCColor.rgb(248, 73, 96));
            m_userColors.put(USERCOLOR70, FCColor.rgb(15, 193, 118));
            m_userColors.put(USERCOLOR71, FCColor.rgba(248, 73, 96, 150));
            m_userColors.put(USERCOLOR72, FCColor.rgba(15, 193, 118, 150));
            m_userColors.put(USERCOLOR73, FCColor.rgb(130, 140, 150));
            m_userColors.put(USERCOLOR74, FCColor.rgba(75, 137, 220, 200)); //1
            m_userColors.put(USERCOLOR75, FCColor.rgb(83, 195, 42));
            m_userColors.put(USERCOLOR76, FCColor.rgb(231, 192, 42));
            m_userColors.put(USERCOLOR77, FCColor.rgb(254, 89, 82));
            m_userColors.put(USERCOLOR78, FCColor.rgba(42, 138, 195, 100));
            m_userColors.put(USERCOLOR79, FCColor.rgb(75, 137, 220));; //1
            m_userColors.put(USERCOLOR80, FCColor.rgba(52, 53, 58, 150));
            m_userColors.put(USERCOLOR81, FCColor.rgb(75, 137, 220)); //1
            m_userColors.put(USERCOLOR82, FCColor.rgba(16, 95, 205, 100));
            m_userColors.put(USERCOLOR83, FCColor.rgb(107, 107, 107));
            m_userColors.put(USERCOLOR84, FCColor.rgb(233, 233, 233));
            m_userColors.put(USERCOLOR85, FCColor.rgb(70, 76, 79));
            m_userColors.put(USERCOLOR86, FCColor.rgba(75, 137, 220, 100)); //1
            m_userColors.put(USERCOLOR87, FCColor.rgb(39, 41, 46));
            m_userColors.put(USERCOLOR88, FCColor.rgb(184, 185, 186));
            m_userColors.put(USERCOLOR89, FCColor.rgb(150, 150, 150));
            m_userColors.put(USERCOLOR90, FCColor.rgb(255, 255, 80));
            m_userColors.put(USERCOLOR91, FCColor.rgba(75, 137, 220, 200)); //1
            m_userColors.put(USERCOLOR92, FCColor.rgba(75, 137, 220, 50));//1
            m_userColors.put(USERCOLOR93, FCColor.rgba(50, 50, 50, 25));
            m_userColors.put(USERCOLOR94, FCColor.rgba(75, 137, 220, 200)); //1
            m_userColors.put(USERCOLOR95, FCColor.rgba(75, 137, 220, 100)); //1
            m_userColors.put(USERCOLOR96, FCColor.rgb(150, 0, 0));
            m_userColors.put(USERCOLOR97, FCColor.rgb(80, 255, 255));
            m_userColors.put(USERCOLOR98, FCColor.rgb(217, 217, 68));
            m_userColors.put(USERCOLOR99, FCColor.rgb(112, 112, 112));
            m_userColors.put(USERCOLOR100, FCColor.rgb(192, 192, 192));
            m_userColors.put(USERCOLOR101, FCColor.rgb(255, 255, 0));
            m_userColors.put(USERCOLOR102, FCColor.rgba(0, 0, 0, 200));
            m_userColors.put(USERCOLOR103, FCColor.rgba(43, 138, 195, 240));
            m_userColors.put(USERCOLOR104, FCColor.rgba(21, 24, 28, 240));
            m_userColors.put(USERCOLOR105, FCColor.rgba(255, 255, 255, 12));
            m_userColors.put(USERCOLOR106, FCColor.rgb(222, 86, 122));
            m_userColors.put(USERCOLOR107, FCColor.rgb(115, 183, 72));
            m_userColors.put(USERCOLOR108, FCColor.rgba(219, 68, 83, 200));
            m_userColors.put(USERCOLOR109, FCColor.rgba(140, 192, 81, 200));
            m_userColors.put(USERCOLOR110, FCColor.rgb(75, 137, 220));
            m_userColors.put(USERCOLOR111, FCColor.rgba(32, 36, 38, 100));
            m_userColors.put(USERCOLOR112, FCColor.rgba(42, 138, 195, 230));
            m_userColors.put(USERCOLOR113, FCColor.rgba(15, 193, 118, 50));
            m_userColors.put(USERCOLOR114, FCColor.rgba(248, 73, 96, 50));
            m_userColors.put(USERCOLOR115, FCColor.rgba(170, 178, 189, 25));
            m_userColors.put(USERCOLOR116, FCColor.rgb(217, 218, 223));
            m_userColors.put(USERCOLOR117, FCColor.rgb(167, 171, 184));
            m_userColors.put(FCColor.Back, FCColor.rgb(19, 21, 26));
            m_userColors.put(FCColor.Border, FCColor.rgb(50, 50, 50));
            m_userColors.put(FCColor.Text, FCColor.rgb(255, 255, 255));
            m_userColors.put(FCColor.DisabledBack, FCColor.rgba(255, 255, 255, 25));
            m_userColors.put(FCColor.DisabledText, 3289650L);
            m_userColors.put(FCColor.Hovered, FCColor.rgba(75, 137, 220, 150)); //1
            m_userColors.put(FCColor.Pushed, FCColor.rgba(75, 137, 220, 100)); //1
        }else if(m_style == 6){
            m_userColors.put(USERCOLOR, FCColor.rgb(230, 230, 230));
            m_userColors.put(USERCOLOR1, FCColor.rgb(230, 230, 230));
            m_userColors.put(USERCOLOR2, FCColor.rgba(255, 255, 255, 100));
            m_userColors.put(USERCOLOR3, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR4, FCColor.rgb(0, 0, 0));
            m_userColors.put(USERCOLOR5, FCColor.rgb(255, 215, 0)); //1
            m_userColors.put(USERCOLOR6, FCColor.rgba(255, 255, 255, 25));
            m_userColors.put(USERCOLOR7, FCColor.rgb(19, 21, 26));
            m_userColors.put(USERCOLOR8, FCColor.rgb(50, 50, 50));
            m_userColors.put(USERCOLOR9, FCColor.rgb(0, 0, 0));
            m_userColors.put(USERCOLOR10, FCColor.rgba(255, 215, 0, 200)); //1
            m_userColors.put(USERCOLOR11, FCColor.rgba(255, 255, 255, 200));
            m_userColors.put(USERCOLOR12, FCColor.rgb(19, 21, 26));
            m_userColors.put(USERCOLOR13, FCColor.rgba(50, 50, 50, 240));
            m_userColors.put(USERCOLOR14, FCColor.rgba(50, 50, 50, 100));
            m_userColors.put(USERCOLOR15, FCColor.rgb(46, 47, 49));;
            m_userColors.put(USERCOLOR16, FCColor.rgb(50, 50, 50));
            m_userColors.put(USERCOLOR17, FCColor.rgb(100, 100, 100));
            m_userColors.put(USERCOLOR18, FCColor.rgba(255, 255, 255, 5));
            m_userColors.put(USERCOLOR19, FCColor.rgba(255, 255, 255, 50));
            m_userColors.put(USERCOLOR20, FCColor.rgb(200, 200, 200));
            m_userColors.put(USERCOLOR21, FCColor.rgb(75, 75, 75));
            m_userColors.put(USERCOLOR22, FCColor.rgb(170, 178, 189));
            m_userColors.put(USERCOLOR23, FCColor.rgba(255, 215, 0, 100)); //1
            m_userColors.put(USERCOLOR24, FCColor.rgb(100, 100, 100));
            m_userColors.put(USERCOLOR25, FCColor.rgb(255, 82, 82));
            m_userColors.put(USERCOLOR26, FCColor.rgb(50, 105, 217));
            m_userColors.put(USERCOLOR27, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR28, FCColor.rgb(200, 200, 200));
            m_userColors.put(USERCOLOR29, FCColor.rgb(80, 80, 80));
            m_userColors.put(USERCOLOR30, FCColor.rgb(25, 25, 25));
            m_userColors.put(USERCOLOR31, FCColor.rgb(255, 0, 0));
            m_userColors.put(USERCOLOR32, FCColor.rgb(139, 180, 248));
            m_userColors.put(USERCOLOR33, FCColor.rgb(0, 165, 137));
            m_userColors.put(USERCOLOR34, FCColor.rgb(230, 230, 230));
            m_userColors.put(USERCOLOR35, FCColor.rgba(100, 100, 100, 200));
            m_userColors.put(USERCOLOR36, FCColor.rgba(255, 215, 0, 150)); //1
            m_userColors.put(USERCOLOR37, FCColor.rgb(255, 80, 80));
            m_userColors.put(USERCOLOR38, FCColor.rgba(255, 215, 0, 25)); //1
            m_userColors.put(USERCOLOR39, FCColor.rgba(51, 153, 255, 75));
            m_userColors.put(USERCOLOR40, FCColor.rgb(0, 200, 0));
            m_userColors.put(USERCOLOR41, FCColor.rgba(0, 0, 0, 10));
            m_userColors.put(USERCOLOR42, FCColor.rgba(50, 50, 50, 50));
            m_userColors.put(USERCOLOR43, FCColor.rgb(0, 105, 217));
            m_userColors.put(USERCOLOR44, FCColor.rgba(255, 255, 255, 150));
            m_userColors.put(USERCOLOR45, FCColor.rgba(255, 0, 0, 200));
            m_userColors.put(USERCOLOR46, FCColor.rgba(170, 178, 189, 50));
            m_userColors.put(USERCOLOR47, FCColor.rgba(170, 178, 189, 200));
            m_userColors.put(USERCOLOR48, FCColor.rgb(219, 68, 83));
            m_userColors.put(USERCOLOR49, FCColor.rgb(255, 80, 80));
            m_userColors.put(USERCOLOR50, FCColor.rgb(246, 187, 67));
            m_userColors.put(USERCOLOR51, FCColor.rgb(59, 174, 218));
            m_userColors.put(USERCOLOR52, FCColor.rgb(216, 112, 173));
            m_userColors.put(USERCOLOR53, FCColor.rgb(140, 192, 81));
            m_userColors.put(USERCOLOR54, FCColor.rgb(80, 255, 80));
            m_userColors.put(USERCOLOR55, FCColor.rgba(255, 80, 80, 200));
            m_userColors.put(USERCOLOR56, FCColor.rgba(50, 50, 50, 150));
            m_userColors.put(USERCOLOR57, FCColor.rgba(0, 105, 217, 240));
            m_userColors.put(USERCOLOR58, FCColor.rgba(0, 0, 0, 25));
            m_userColors.put(USERCOLOR59, FCColor.rgb(255, 215, 0));
            m_userColors.put(USERCOLOR60, FCColor.rgb(150, 150, 150));
            m_userColors.put(USERCOLOR61, FCColor.rgba(0, 0, 0, 200));
            m_userColors.put(USERCOLOR62, FCColor.rgba(255, 215, 0, 50)); //1
            m_userColors.put(USERCOLOR63, FCColor.rgb(10, 36, 106));
            m_userColors.put(USERCOLOR64, FCColor.rgb(21, 24, 28));
            m_userColors.put(USERCOLOR65, FCColor.rgba(0, 0, 0, 100));
            m_userColors.put(USERCOLOR66, FCColor.rgba(0, 0, 0, 50));
            m_userColors.put(USERCOLOR67, FCColor.rgb(230, 230, 230));
            m_userColors.put(USERCOLOR68, FCColor.rgb(32, 36, 38));
            m_userColors.put(USERCOLOR69, FCColor.rgb(248, 73, 96));
            m_userColors.put(USERCOLOR70, FCColor.rgb(15, 193, 118));
            m_userColors.put(USERCOLOR71, FCColor.rgba(248, 73, 96, 150));
            m_userColors.put(USERCOLOR72, FCColor.rgba(15, 193, 118, 150));
            m_userColors.put(USERCOLOR73, FCColor.rgb(130, 140, 150));
            m_userColors.put(USERCOLOR74, FCColor.rgba(94, 102, 115, 200));
            m_userColors.put(USERCOLOR75, FCColor.rgb(83, 195, 42));
            m_userColors.put(USERCOLOR76, FCColor.rgb(231, 192, 42));
            m_userColors.put(USERCOLOR77, FCColor.rgb(254, 89, 82));
            m_userColors.put(USERCOLOR78, FCColor.rgba(42, 138, 195, 100));
            m_userColors.put(USERCOLOR79, FCColor.rgb(52, 53, 58));
            m_userColors.put(USERCOLOR80, FCColor.rgba(52, 53, 58, 150));
            m_userColors.put(USERCOLOR81, FCColor.rgb(16, 95, 205));
            m_userColors.put(USERCOLOR82, FCColor.rgba(16, 95, 205, 100));
            m_userColors.put(USERCOLOR83, FCColor.rgb(107, 107, 107));
            m_userColors.put(USERCOLOR84, FCColor.rgb(233, 233, 233));
            m_userColors.put(USERCOLOR85, FCColor.rgb(70, 76, 79));
            m_userColors.put(USERCOLOR86, FCColor.rgb(50, 82, 114));
            m_userColors.put(USERCOLOR87, FCColor.rgb(39, 41, 46));
            m_userColors.put(USERCOLOR88, FCColor.rgb(184, 185, 186));
            m_userColors.put(USERCOLOR89, FCColor.rgb(150, 150, 150));
            m_userColors.put(USERCOLOR90, FCColor.rgb(255, 255, 80));
            m_userColors.put(USERCOLOR91, FCColor.rgba(42, 138, 195, 200));
            m_userColors.put(USERCOLOR92, FCColor.rgba(32, 36, 38, 50));;
            m_userColors.put(USERCOLOR93, FCColor.rgba(50, 50, 50, 25));
            m_userColors.put(USERCOLOR94, FCColor.rgb(50, 50, 50));
            m_userColors.put(USERCOLOR95, FCColor.rgb(128, 128, 128));
            m_userColors.put(USERCOLOR96, FCColor.rgb(150, 0, 0));
            m_userColors.put(USERCOLOR97, FCColor.rgb(80, 255, 255));
            m_userColors.put(USERCOLOR98, FCColor.rgb(217, 217, 68));
            m_userColors.put(USERCOLOR99, FCColor.rgb(112, 112, 112));
            m_userColors.put(USERCOLOR100, FCColor.rgb(192, 192, 192));
            m_userColors.put(USERCOLOR101, FCColor.rgb(255, 255, 0));
            m_userColors.put(USERCOLOR102, FCColor.rgba(0, 0, 0, 200));
            m_userColors.put(USERCOLOR103, FCColor.rgba(43, 138, 195, 240));
            m_userColors.put(USERCOLOR104, FCColor.rgba(21, 24, 28, 240));
            m_userColors.put(USERCOLOR105, FCColor.rgba(255, 255, 255, 12));
            m_userColors.put(USERCOLOR106, FCColor.rgb(222, 86, 122));
            m_userColors.put(USERCOLOR107, FCColor.rgb(115, 183, 72));
            m_userColors.put(USERCOLOR108, FCColor.rgba(219, 68, 83, 200));
            m_userColors.put(USERCOLOR109, FCColor.rgba(140, 192, 81, 200));
            m_userColors.put(USERCOLOR110, FCColor.rgb(15, 193, 118));
            m_userColors.put(USERCOLOR111, FCColor.rgba(32, 36, 38, 100));
            m_userColors.put(USERCOLOR112, FCColor.rgba(42, 138, 195, 230));
            m_userColors.put(USERCOLOR113, FCColor.rgba(15, 193, 118, 50));
            m_userColors.put(USERCOLOR114, FCColor.rgba(248, 73, 96, 50));
            m_userColors.put(USERCOLOR115, FCColor.rgba(170, 178, 189, 25));
            m_userColors.put(USERCOLOR116, FCColor.rgb(217, 218, 223));
            m_userColors.put(USERCOLOR117, FCColor.rgb(167, 171, 184));
            m_userColors.put(FCColor.Back, FCColor.rgb(19, 21, 26));
            m_userColors.put(FCColor.Border, FCColor.rgb(50, 50, 50));
            m_userColors.put(FCColor.Text, FCColor.rgb(255, 255, 255));
            m_userColors.put(FCColor.DisabledBack, FCColor.rgba(255, 255, 255, 25));
            m_userColors.put(FCColor.DisabledText, 3289650L);
            m_userColors.put(FCColor.Hovered, FCColor.rgba(43, 138, 195, 150));
            m_userColors.put(FCColor.Pushed, FCColor.rgba(43, 138, 195, 100));
        }else{
            m_userColors.put(USERCOLOR, FCColor.rgb(230, 230, 230));
            m_userColors.put(USERCOLOR1, FCColor.rgb(230, 230, 230));
            m_userColors.put(USERCOLOR2, FCColor.rgba(255, 255, 255, 100));
            m_userColors.put(USERCOLOR3, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR4, FCColor.rgb(0, 0, 0));
            m_userColors.put(USERCOLOR5, FCColor.rgb(42, 138, 195));
            m_userColors.put(USERCOLOR6, FCColor.rgba(255, 255, 255, 25));
            m_userColors.put(USERCOLOR7, FCColor.rgb(19, 21, 26));
            m_userColors.put(USERCOLOR8, FCColor.rgb(50, 50, 50));
            m_userColors.put(USERCOLOR9, FCColor.rgb(0, 0, 0));
            m_userColors.put(USERCOLOR10, FCColor.rgb(43, 138, 195));
            m_userColors.put(USERCOLOR11, FCColor.rgba(255, 255, 255, 200));
            m_userColors.put(USERCOLOR12, FCColor.rgb(19, 21, 26));
            m_userColors.put(USERCOLOR13, FCColor.rgba(50, 50, 50, 240));
            m_userColors.put(USERCOLOR14, FCColor.rgba(50, 50, 50, 100));
            m_userColors.put(USERCOLOR15, FCColor.rgb(46, 47, 49));;
            m_userColors.put(USERCOLOR16, FCColor.rgb(50, 50, 50));
            m_userColors.put(USERCOLOR17, FCColor.rgb(100, 100, 100));
            m_userColors.put(USERCOLOR18, FCColor.rgba(255, 255, 255, 5));
            m_userColors.put(USERCOLOR19, FCColor.rgba(255, 255, 255, 50));
            m_userColors.put(USERCOLOR20, FCColor.rgb(200, 200, 200));
            m_userColors.put(USERCOLOR21, FCColor.rgb(75, 75, 75));
            m_userColors.put(USERCOLOR22, FCColor.rgb(170, 178, 189));
            m_userColors.put(USERCOLOR23, FCColor.rgba(43, 138, 195, 100));
            m_userColors.put(USERCOLOR24, FCColor.rgb(100, 100, 100));
            m_userColors.put(USERCOLOR25, FCColor.rgb(255, 82, 82));
            m_userColors.put(USERCOLOR26, FCColor.rgb(50, 105, 217));
            m_userColors.put(USERCOLOR27, FCColor.rgb(255, 255, 255));
            m_userColors.put(USERCOLOR28, FCColor.rgb(200, 200, 200));
            m_userColors.put(USERCOLOR29, FCColor.rgb(80, 80, 80));
            m_userColors.put(USERCOLOR30, FCColor.rgb(25, 25, 25));
            m_userColors.put(USERCOLOR31, FCColor.rgb(255, 0, 0));
            m_userColors.put(USERCOLOR32, FCColor.rgb(139, 180, 248));
            m_userColors.put(USERCOLOR33, FCColor.rgb(0, 165, 137));
            m_userColors.put(USERCOLOR34, FCColor.rgb(230, 230, 230));
            m_userColors.put(USERCOLOR35, FCColor.rgba(100, 100, 100, 200));
            m_userColors.put(USERCOLOR36, FCColor.rgba(43, 138, 195, 200));
            m_userColors.put(USERCOLOR37, FCColor.rgb(255, 80, 80));
            m_userColors.put(USERCOLOR38, FCColor.rgba(43, 138, 195, 25));
            m_userColors.put(USERCOLOR39, FCColor.rgba(51, 153, 255, 75));
            m_userColors.put(USERCOLOR40, FCColor.rgb(0, 200, 0));
            m_userColors.put(USERCOLOR41, FCColor.rgba(0, 0, 0, 10));
            m_userColors.put(USERCOLOR42, FCColor.rgba(50, 50, 50, 50));
            m_userColors.put(USERCOLOR43, FCColor.rgb(0, 105, 217));
            m_userColors.put(USERCOLOR44, FCColor.rgba(255, 255, 255, 150));
            m_userColors.put(USERCOLOR45, FCColor.rgba(255, 0, 0, 200));
            m_userColors.put(USERCOLOR46, FCColor.rgba(170, 178, 189, 50));
            m_userColors.put(USERCOLOR47, FCColor.rgba(170, 178, 189, 200));
            m_userColors.put(USERCOLOR48, FCColor.rgb(219, 68, 83));
            m_userColors.put(USERCOLOR49, FCColor.rgb(255, 80, 80));
            m_userColors.put(USERCOLOR50, FCColor.rgb(246, 187, 67));
            m_userColors.put(USERCOLOR51, FCColor.rgb(59, 174, 218));
            m_userColors.put(USERCOLOR52, FCColor.rgb(216, 112, 173));
            m_userColors.put(USERCOLOR53, FCColor.rgb(140, 192, 81));
            m_userColors.put(USERCOLOR54, FCColor.rgb(80, 255, 80));
            m_userColors.put(USERCOLOR55, FCColor.rgba(255, 80, 80, 200));
            m_userColors.put(USERCOLOR56, FCColor.rgba(50, 50, 50, 150));
            m_userColors.put(USERCOLOR57, FCColor.rgba(0, 105, 217, 240));
            m_userColors.put(USERCOLOR58, FCColor.rgba(0, 0, 0, 25));
            m_userColors.put(USERCOLOR59, FCColor.rgb(255, 215, 0));
            m_userColors.put(USERCOLOR60, FCColor.rgb(150, 150, 150));
            m_userColors.put(USERCOLOR61, FCColor.rgba(0, 0, 0, 200));
            m_userColors.put(USERCOLOR62, FCColor.rgba(43, 138, 195, 50));
            m_userColors.put(USERCOLOR63, FCColor.rgb(10, 36, 106));
            m_userColors.put(USERCOLOR64, FCColor.rgb(21, 24, 28));
            m_userColors.put(USERCOLOR65, FCColor.rgba(0, 0, 0, 100));
            m_userColors.put(USERCOLOR66, FCColor.rgba(0, 0, 0, 50));
            m_userColors.put(USERCOLOR67, FCColor.rgb(230, 230, 230));
            m_userColors.put(USERCOLOR68, FCColor.rgb(32, 36, 38));
            m_userColors.put(USERCOLOR69, FCColor.rgb(248, 73, 96));
            m_userColors.put(USERCOLOR70, FCColor.rgb(15, 193, 118));
            m_userColors.put(USERCOLOR71, FCColor.rgba(248, 73, 96, 150));
            m_userColors.put(USERCOLOR72, FCColor.rgba(15, 193, 118, 150));
            m_userColors.put(USERCOLOR73, FCColor.rgb(130, 140, 150));
            m_userColors.put(USERCOLOR74, FCColor.rgba(94, 102, 115, 200));
            m_userColors.put(USERCOLOR75, FCColor.rgb(83, 195, 42));
            m_userColors.put(USERCOLOR76, FCColor.rgb(231, 192, 42));
            m_userColors.put(USERCOLOR77, FCColor.rgb(254, 89, 82));
            m_userColors.put(USERCOLOR78, FCColor.rgba(42, 138, 195, 100));
            m_userColors.put(USERCOLOR79, FCColor.rgb(52, 53, 58));
            m_userColors.put(USERCOLOR80, FCColor.rgba(52, 53, 58, 150));
            m_userColors.put(USERCOLOR81, FCColor.rgb(16, 95, 205));
            m_userColors.put(USERCOLOR82, FCColor.rgba(16, 95, 205, 100));
            m_userColors.put(USERCOLOR83, FCColor.rgb(107, 107, 107));
            m_userColors.put(USERCOLOR84, FCColor.rgb(233, 233, 233));
            m_userColors.put(USERCOLOR85, FCColor.rgb(70, 76, 79));
            m_userColors.put(USERCOLOR86, FCColor.rgb(50, 82, 114));
            m_userColors.put(USERCOLOR87, FCColor.rgb(39, 41, 46));
            m_userColors.put(USERCOLOR88, FCColor.rgb(184, 185, 186));
            m_userColors.put(USERCOLOR89, FCColor.rgb(150, 150, 150));
            m_userColors.put(USERCOLOR90, FCColor.rgb(255, 255, 80));
            m_userColors.put(USERCOLOR91, FCColor.rgba(42, 138, 195, 200));
            m_userColors.put(USERCOLOR92, FCColor.rgba(32, 36, 38, 50));;
            m_userColors.put(USERCOLOR93, FCColor.rgba(50, 50, 50, 25));
            m_userColors.put(USERCOLOR94, FCColor.rgb(50, 50, 50));
            m_userColors.put(USERCOLOR95, FCColor.rgb(128, 128, 128));
            m_userColors.put(USERCOLOR96, FCColor.rgb(150, 0, 0));
            m_userColors.put(USERCOLOR97, FCColor.rgb(80, 255, 255));
            m_userColors.put(USERCOLOR98, FCColor.rgb(217, 217, 68));
            m_userColors.put(USERCOLOR99, FCColor.rgb(112, 112, 112));
            m_userColors.put(USERCOLOR100, FCColor.rgb(192, 192, 192));
            m_userColors.put(USERCOLOR101, FCColor.rgb(255, 255, 0));
            m_userColors.put(USERCOLOR102, FCColor.rgba(0, 0, 0, 200));
            m_userColors.put(USERCOLOR103, FCColor.rgba(43, 138, 195, 240));
            m_userColors.put(USERCOLOR104, FCColor.rgba(21, 24, 28, 240));
            m_userColors.put(USERCOLOR105, FCColor.rgba(255, 255, 255, 12));
            m_userColors.put(USERCOLOR106, FCColor.rgb(222, 86, 122));
            m_userColors.put(USERCOLOR107, FCColor.rgb(115, 183, 72));
            m_userColors.put(USERCOLOR108, FCColor.rgba(219, 68, 83, 200));
            m_userColors.put(USERCOLOR109, FCColor.rgba(140, 192, 81, 200));
            m_userColors.put(USERCOLOR110, FCColor.rgb(15, 193, 118));
            m_userColors.put(USERCOLOR111, FCColor.rgba(32, 36, 38, 100));
            m_userColors.put(USERCOLOR112, FCColor.rgba(42, 138, 195, 230));
            m_userColors.put(USERCOLOR113, FCColor.rgba(15, 193, 118, 50));
            m_userColors.put(USERCOLOR114, FCColor.rgba(248, 73, 96, 50));
            m_userColors.put(USERCOLOR115, FCColor.rgba(170, 178, 189, 25));
            m_userColors.put(USERCOLOR116, FCColor.rgb(217, 218, 223));
            m_userColors.put(USERCOLOR117, FCColor.rgb(167, 171, 184));
            m_userColors.put(FCColor.Back, FCColor.rgb(19, 21, 26));
            m_userColors.put(FCColor.Border, FCColor.rgb(50, 50, 50));
            m_userColors.put(FCColor.Text, FCColor.rgb(255, 255, 255));
            m_userColors.put(FCColor.DisabledBack, FCColor.rgba(255, 255, 255, 25));
            m_userColors.put(FCColor.DisabledText, 3289650L);
            m_userColors.put(FCColor.Hovered, FCColor.rgba(43, 138, 195, 150));
            m_userColors.put(FCColor.Pushed, FCColor.rgba(43, 138, 195, 100));
        }
        m_myColors.clear();
        m_gdiColors.clear();
    }

    /**
     * 获取用户颜色
     * @param color
     * @return
     */
    public long getUserColor(long color)
    {
        if (m_lastStyle != m_style)
        {
            if(m_lastStyle == -1)
            {
                m_style = 0;
            }
            m_lastStyle = m_style;
            createColors();
        }
        if (m_myColors.size() > 0 && m_myColors.containsKey(color))
        {
            color = m_myColors.get(color);
        }
        else
        {
            if (m_userColors.containsKey(color))
            {
                color = m_userColors.get(color);
            }
        }
        return color;
    }

    /**
     * 系统颜色缓存
     */
    public HashMap<Long, Integer> m_gdiColors = new HashMap<Long, Integer>();
}
