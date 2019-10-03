package ru.kazakovushka.edu;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final String sharedKey = "SHARED_KEY";

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @GetMapping
    public BaseResponse showStatus() {
        return new BaseResponse(1, SUCCESS_STATUS);
    }

    @PostMapping("/pay")
    public BaseResponse pay(@RequestParam(value = "key") String key, @RequestBody Payment payment) {
        final BaseResponse baseResponse;

        if(sharedKey.equalsIgnoreCase(key)){
            int userId = payment.getUserId();
            String itemId = payment.getItemId();
            double discount = payment.getDiscount();

            baseResponse = new BaseResponse(CODE_SUCCESS, SUCCESS_STATUS);
        }else{
            baseResponse = new BaseResponse(AUTH_FAILURE, ERROR_STATUS);
        }
        return baseResponse;
    }
}
