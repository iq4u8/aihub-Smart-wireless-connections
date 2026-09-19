const __gzlSendCallbackMap__ = {};
const __gzlSendNativeCallbackMap__ = {};
var __gzlCallbackNum__ = 0;
var __gzlNativeCallbackNum__ = 0;
if (window.gzlJSBridge == undefined) {
	window.gzlJSBridge = {};
}
function __gzlSendMsgCallback__(num, value) {
	if (value == undefined || value == "undefined" || value == null) {
	    value = {};
	}
	if (__gzlSendCallbackMap__[num]) {
		__gzlSendCallbackMap__[num](value);
		delete __gzlSendCallbackMap__[num];
	}
}
function __gzlWebViewInvoke__(args, callback) {
	__gzlCallbackNum__ = __gzlCallbackNum__ + 1;
	if(__gzlCallbackNum__ > 2147483647) {
	    __gzlCallbackNum__ = 1;
	}
	window.nativeJSBridge.viewInvoke(args, __gzlCallbackNum__);
	if (callback != undefined) {
		__gzlSendCallbackMap__[__gzlCallbackNum__] = callback;
	}
}
window.gzlJSBridge.viewInvoke = __gzlWebViewInvoke__;

function __gzlViewHandlerBack__(callbackId) {
	if (callbackId === undefined || callbackId === null) {
		return null;
	}
	return function(args) {
		window.nativeJSBridge.viewHandlerMethodCallback(callbackId, args);
	};
}
window.gzlViewHandlerBack = __gzlViewHandlerBack__;

function __gzlSendNativeMsgCallback__(num, value) {
	if (value == undefined || value == null) return;
	if (__gzlSendNativeCallbackMap__[num]) {
		__gzlSendNativeCallbackMap__[num](value);
		delete __gzlSendNativeCallbackMap__[num];
	}
}
function __gzlNativeInvoke__(args, callback) {
	__gzlNativeCallbackNum__ = __gzlNativeCallbackNum__ + 1;
	if(__gzlNativeCallbackNum__ > 2147483647) {
	    __gzlNativeCallbackNum__ = 1;
	}
	window.nativeJSBridge.nativeInvokes(args, __gzlNativeCallbackNum__);
	if (callback != undefined) {
		__gzlSendNativeCallbackMap__[__gzlNativeCallbackNum__] = callback;
	}
}

window.gzlJSBridge.nativeInvoke = __gzlNativeInvoke__;

function __gzlNativeHandlerBack__(callbackId,result) {
	if (callbackId === undefined || callbackId === null) {
		return null;
	}
	__gzlSendNativeCallbackMap__[callbackId](result)
}

window.gzlNativeHandlerBack = __gzlNativeHandlerBack__;

function __webViewViewLoaded__(webViewId) {
    window.nativeJSBridge.onViewLoaded();
}
window.__VIEW_LOADED__ = __webViewViewLoaded__;

function __gzlWebViewInvokeNative__(action, data) {
    window.nativeJSBridge.viewInvokeNative(action, data);
}
window.gzlJSBridge.viewInvokeNative = __gzlWebViewInvokeNative__;
