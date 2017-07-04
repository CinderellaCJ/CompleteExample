package com.cj.completeexample.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cj.completeexample.R;
import com.cj.completeexample.bean.Person;
import com.cj.completeexample.interf.HttpCallBackListener;
import com.cj.completeexample.utils.HttpUtil;
import com.cj.completeexample.utils.LogUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class HttpActivity extends BaseActivity {


    @BindView(R.id.txt_request)
    TextView txtRequest;
    @BindView(R.id.btn_send)
    Button btnSend;
    @BindView(R.id.btn_okhttp)
    Button btnOkhttp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_send, R.id.btn_okhttp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_send:
                sendRequestWithHttpConnect();
                break;
            case R.id.btn_okhttp:
                sendRequestWithOkHttp();
                break;
        }
    }

    private void sendRequestWithHttpConnect() {
        HttpUtil.sendRequestWithHttpConnect("http://192.168.2.101/testDate.json", new HttpCallBackListener() {
            @Override
            public void onFinish(String response) {
                showResponse(response);
                parseJsonWithGson(response);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    private void sendRequestWithOkHttp() {
        HttpUtil.sendRequestWithOkHttp("http://192.168.2.101/testDate.json", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseDate = response.body().string();
                showResponse(responseDate);
                parseJsonWithGson(responseDate);

            }
        });

    }

    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                txtRequest.setText(response);
            }
        });
    }

    private void parseXmlWithPull(String responseData) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new StringReader(responseData));
            int eventType = parser.getEventType();
            String id = "";
            String name = "";
            while (eventType != XmlPullParser.END_DOCUMENT){
                String nodeName = parser.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if ("id".equals(nodeName)){
                            id = parser.nextText();
                        }else if ("name".equals(nodeName)){
                            name = parser.nextText();
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("song".equals(nodeName)){
                            LogUtil.d(id + name);
                        }
                        break;
                    default:
                        break;
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseJsonWithJsonObject(String reponseDate){
        try {
            JSONArray jsonArray = new JSONArray(reponseDate);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id= jsonObject.getString("id");
                String name = jsonObject.getString("name");
                LogUtil.d(id + name);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseJsonWithGson(String resposeDate){
        Gson gson = new Gson();
        List<Person> personList = gson.fromJson(resposeDate,new TypeToken<List<Person>>(){}.getType());
        for (Person per : personList){
            String id = per.getId();
            String name = per.getName();
            LogUtil.d(id + name);
        }

    }



}
