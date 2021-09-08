package com.fzy.xiaoshuo.controller;

import cn.hutool.core.map.MapUtil;
import com.fzy.xiaoshuo.common.Result;
import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class AuthController extends BaseController {
    @Autowired
    private Producer producer;
//
//    /**
//     * 图片验证码
//     */
    @GetMapping("/captcha")
    public Result captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 生成随机五位数验证码
        String code = producer.createText();
        // 生成key 存到redis
        String key = UUID.randomUUID().toString();
        // 生成图片
        BufferedImage image = producer.createImage(code);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        BASE64Encoder encoder = new BASE64Encoder();
        String str = "data:image/jpeg;base64,";
        String base64Img = str + encoder.encode(outputStream.toByteArray());
        // 存储到redis中
        redisUtils.set(key,code,120L);
        log.info("验证码 -- {} - {}", key, code);
        return Result.success(MapUtil.builder().put("token", key).put("base64Img", base64Img).build());
    }
}
