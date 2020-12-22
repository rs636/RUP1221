package org.techtown.rup;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    final static private String URL="rup.dothome.co.kr/Register.php";
    private Map<String,String> map;
    public RegisterRequest(String Id, String Pw, String Name, String Phone, String Email, boolean Event, Integer Birthday, Integer Account, String Bank, Response .Listener<String>listener){
        super(Method.POST,URL,listener,null);
        map=new HashMap<>();
        map.put("userId",Id);
        map.put("userPw",Pw);
        map.put("userName",Name);
        map.put("userPhone",Phone);
        map.put("userEmail",Email);
        map.put("userBirthday",Birthday+"");
        map.put("userAccount",Account+"");
        map.put("userBank",Bank);
        if(Event){
            //이벤트 수신에 동의하는 경우
            map.put("userEvent","0");
        }else{
            //이벤트 수신에 동의 하지 않는 경우
            map.put("userEvent","1");
        }
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
