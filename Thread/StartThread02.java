package Thread;

/**
 * 多线程下载图片
 * @author: CTH
 **/
public class StartThread02 extends Thread {
    private String url;
    private String path;
    public StartThread02(String url, String path) {
        this.url = url;
        this.path = path;
    }


    @Override
    public void run() {
        WebDownload wd = new WebDownload();
        wd.downloadImage(url, path);
    }

    public static void main(String[] args) {

        StartThread02 st1 = new StartThread02("https://cn.bing.com/images/search?view=detailV2&ccid=WxtKYcVX&id=17FA7D7B543A2583A77A59A0E5EDD8F8016BCBF4&thid=OIP.WxtKYcVX6O5__8RE3MKmygHaFI&mediaurl=http%3a%2f%2fwww.jingqu123.cn%2fImage%2f2009041717445199.jpg&exph=710&expw=1024&q=70%e5%91%a8%e5%b9%b4%e5%9b%bd%e5%ba%86%e6%b4%bb%e5%8a%a8%e5%ae%89%e6%8e%92%e5%ae%8c%e6%95%b4%e7%89%88%e5%87%ba%e7%82%89&simid=608014763730994611&selectedIndex=0&ajaxhist=0", "src/Thread/tian.jpg");
        StartThread02 st2 = new StartThread02("https://cn.bing.com/images/search?view=detailV2&ccid=QmpE4izN&id=60BDC94797DBBC590A4A500E96576594D743814A&thid=OIP.QmpE4izNGHOt-_ql6PHPGwHaFj&mediaurl=http%3a%2f%2fpic16.nipic.com%2f20110907%2f7075174_095411295195_2.jpg&exph=768&expw=1024&q=%e5%88%98%e4%ba%a6%e8%8f%b2&simid=608042775475851236&selectedIndex=9&ajaxhist=0", "src/Thread/小龙女.jpg");
        StartThread02 st3 = new StartThread02("https://cn.bing.com/images/search?view=detailV2&ccid=0khwHS7%2b&id=2A7CF682CFEE6133C444E3986D088FB08F98AEA9&thid=OIP.0khwHS7-RMMo5_WQzDo6EAHaLH&mediaurl=http%3a%2f%2fimg1.3lian.com%2f2015%2fw8%2f31%2fd%2f101.jpg&exph=1050&expw=700&q=%e5%88%98%e4%ba%a6%e8%8f%b2&simid=608004996936893732&selectedIndex=19&ajaxhist=0", "src/Thread/lyf.jpg");
        st1.start();
        st2.start();
        st3.start();

    }

}
