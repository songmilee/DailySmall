package mi.song.dailysmall.base;

import android.Manifest;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

import mi.song.dailysmall.def.ReqCode;


public abstract class BaseActivity extends AppCompatActivity {

    abstract protected void init();

    protected boolean checkPermission(String[] permissions){
        int result;
        ArrayList<String> permissionList = new ArrayList<>();

        for(String permission : permissions){
            result = ContextCompat.checkSelfPermission(this, permission);

            if(result != PackageManager.PERMISSION_GRANTED){
                permissionList.add(permission);
            }
        }

        if(!permissionList.isEmpty()){
            String[] perList = new String[permissionList.size()];
            ActivityCompat.requestPermissions(this, permissionList.toArray(perList), ReqCode.REQ_PERMISSION);
            return false;
        }

        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        int size = permissions.length;
        if(requestCode == ReqCode.REQ_PERMISSION){
            if(grantResults.length > 0){
                for(int i = 0; i < size; i++){
                    if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                        permissionDeny();
                    }
                }
            } else {
                permissionDeny();
            }
        }
    }

    public void permissionDeny(){
        Toast.makeText(this, "Sorry Permission Denied", Toast.LENGTH_SHORT).show();
    }
}
