package com.romazal.ecommerce.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @PostMapping("/create")
    public ResponseEntity<UUID> createPayment(@RequestBody PaymentRequest paymentRequest) {
        return ResponseEntity.ok(service.createPayment(paymentRequest));
    }

    @PutMapping("/confirm/{payment-id}")
    public ResponseEntity<UUID> confirmPayment(@PathVariable("payment-id") UUID paymentId) {
        return ResponseEntity.ok(service.confirmPayment(paymentId));
    }

    @PutMapping("/fail/{payment-id}")
    public ResponseEntity<UUID> failPayment(@PathVariable("payment-id") UUID paymentId) {
        return ResponseEntity.ok(service.failPayment(paymentId));
    }

    @PutMapping("/refund/{payment-id}")
    public ResponseEntity<UUID> refundPayment(@PathVariable("payment-id") UUID paymentId) {
        return ResponseEntity.ok(service.refundPayment(paymentId));
    }

    @PostMapping("/fail/order/{order-id}")
    public ResponseEntity<UUID> failPaymentByOrderId(@PathVariable("order-id") UUID orderId){
        return ResponseEntity.ok(service.failPaymentByOrderId(orderId));
    }

    @PostMapping("/refund/order/{order-id}")
    public ResponseEntity<UUID> refundPaymentByOrderId(@PathVariable("order-id") UUID orderId){
        return ResponseEntity.ok(service.refundPaymentByOrderId(orderId));
    }

    @GetMapping
    public ResponseEntity<List<PaymentResponse>> getAllPayments() {
        return ResponseEntity.ok(service.getAllPayments());
    }

    @GetMapping("/payment/{payment-id}")
    public ResponseEntity<PaymentResponse> getPaymentByPaymentId(@PathVariable("payment-id") UUID paymentId) {
        return ResponseEntity.ok(service.getPaymentById(paymentId));
    }

    @GetMapping("/order/{order-id}")
    public ResponseEntity<PaymentResponse> getPaymentByOrderId(@PathVariable("order-id") UUID orderId) {
        return ResponseEntity.ok(service.getPaymentByOrderId(orderId));
    }

    @GetMapping("/status/payment/{payment-id}")
    public ResponseEntity<PaymentStatus> getPaymentStatusByPaymentId(@PathVariable("payment-id") UUID paymentId) {
        return ResponseEntity.ok(service.getPaymentStatusByPaymentId(paymentId));
    }

    @GetMapping("/status/order/{order-id}")
    public ResponseEntity<PaymentStatus> getPaymentStatusByOrderId(@PathVariable("order-id") UUID orderId) {
        return ResponseEntity.ok(service.getPaymentStatusByOrderId(orderId));
    }

    @GetMapping("/history/order/{order-id}")
    public ResponseEntity<List<PaymentResponse>> getPaymentHistoryByOrderId(@PathVariable("order-id") UUID orderId) {
        return ResponseEntity.ok(service.getPaymentHistoryByOrderId(orderId));
    }

}
