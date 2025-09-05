package cn.abel.meta.controller;


import cn.abel.meta.vo.ResponseMsg;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    /**
     * 开源测试
     * @return
     */

    @GetMapping("test")
    public ResponseMsg test() {
        return ResponseMsg.ok();
    }


    /**9eb95962bc0664eb0ba01f5476a8ce1c7860ef2b
     * 开源测试1
     * @return
     */
    @GetMapping("test1")
    public ResponseMsg test1() {
        return ResponseMsg.ok();
    }
}
