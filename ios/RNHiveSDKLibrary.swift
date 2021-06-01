//
//  RNPaymentSDKLibrary.swift
//  react-native-paymentsdk
//
//  Created by Mohamed Adly on 16/03/2021.
//

import Foundation
import PaymentSDK

@objc(RNPaymentSDKLibrary)
class RNPaymentSDKLibrary: NSObject {
    var resolve: RCTPromiseResolveBlock?
    var reject: RCTPromiseRejectBlock?

    @objc(startSurvey:withResolver:withRejecter:)
    func startSurvey(paymentDetails: NSString,
                          resolve: @escaping RCTPromiseResolveBlock,
                          reject: @escaping RCTPromiseRejectBlock) -> Void {
        self.resolve = resolve
        self.reject = reject
        
        let data = Data((paymentDetails as String).utf8)
        do {
            let dictionary = try JSONSerialization.jsonObject(with: data, options: JSONSerialization.ReadingOptions.allowFragments) as! [String: Any]
            var userName=dictionary["userName"]
            var password =dictionary["password"]
            //todo start survey here
        } catch let error {
            reject("Error", error.localizedDescription, error)
        }
    }
    
}
