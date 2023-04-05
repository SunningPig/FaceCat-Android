package topin.facecat.FaceCat;

import Product.Service.DataCenter;
import Product.UI.MainFrame;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;

import Android.FCUIVIew;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import facecat.topin.sock.FCClientSocket;

import java.io.DataInputStream;
import java.io.InputStream;

import static android.content.pm.PackageManager.PERMISSION_DENIED;

/*
* 主视图
 */
public class MainActivity extends AppCompatActivity{
    /**
     * 读取XML
     * @param FileId
     * @return
     */
    private String getXMlString(int FileId) {
        InputStream in = getResources().openRawResource(FileId);
        DataInputStream din = null;
        try {
            din = new DataInputStream(in);
            byte[] bytes = new byte[din.available()];
            din.read(bytes);
            String ret = new String(bytes, "UTF-8");
            din.close();
            bytes = null;
            return ret;
        } catch (Exception e) {
            try {
                din.close();
            } catch (Exception e2) {
                return null;
            }
            return null;
        }
    }

    /*
    * 主视图静态对象
     */
    public static MainActivity m_mainActivity;

    /**
     * 创建视图
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (m_mainActivity != null && m_mainActivity != this){
            finish();
            return;
        }
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        m_mainActivity = this;
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
        }
        FCClientSocket.noThread = false;

        FCUIVIew view = new FCUIVIew(getBaseContext());
        view.setAllowScroll(false);
        view.onLoad();
        MainFrame mainFrame = new MainFrame();
        mainFrame.setNative(view.getNative());
        mainFrame.loadXml(getXMlString(R.raw.mainframe),  null);
        //view.setLoadUI(m_chatMainFrame);
        setContentView(view);
        mainFrame.getNative().update();
        mainFrame.getNative().invalidate();
    }

    /**
     * 回退
     */
    public void onBackPressed(){
        moveTaskToBack(true);
    }

    /**
     * 配置改变
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub
        try {
            super.onConfigurationChanged(newConfig);
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
