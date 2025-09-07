package cn.abel.meta.controller;

import com.unfbx.chatgpt.OpenAiClient;
import com.unfbx.chatgpt.entity.chat.ChatCompletion;
import com.unfbx.chatgpt.entity.chat.ChatCompletionResponse;
import com.unfbx.chatgpt.entity.chat.Message;
import com.unfbx.chatgpt.interceptor.OpenAILogger;
import okhttp3.logging.HttpLoggingInterceptor;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;

public class Demo {


    private OpenAiClient v2;

     {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7890));
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new OpenAILogger());
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        v2 = new OpenAiClient("sk-******************************************");
//        v2 = new OpenAiClient("sk-******************************************", null, null);
//        v2 = new OpenAiClient("sk-**********************************",
//                120,
//                120,
//                120,
//                proxy,
//                httpLoggingInterceptor);

        v2 = OpenAiClient.builder()
                .apiKey("sk-**********************************")
                .connectTimeout(50)
                .writeTimeout(50)
                .readTimeout(50)
                .interceptor(Arrays.asList(httpLoggingInterceptor))
//                .proxy(proxy)
                .build();
    }


    public void chat() {
        //聊天模型：gpt-3.5
        Message message = Message.builder().role(Message.Role.USER).content("你好啊我的伙伴！").build();
        ChatCompletion chatCompletion = ChatCompletion.builder().messages(Arrays.asList(message)).build();
        ChatCompletionResponse chatCompletionResponse = v2.chatCompletion(chatCompletion);
        chatCompletionResponse.getChoices().forEach(e -> {
            System.out.println(e.getMessage());
        });
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.chat();

    }
}
