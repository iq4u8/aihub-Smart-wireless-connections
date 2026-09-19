const __widgetSuccessCallbackMap__ = {};
const __widgetFailCallbackMap__ = {};
var __widgetCallbackNum__ = 0;
if(typeof window == 'undefined'){
    window = globalThis;
}
if (window.gzlJSBridge == undefined) {
    window.gzlJSBridge = {};
}
const __MiniAppId__ = '${__MiniAppId__}';
const __MiniWidgetPath__ = '${__MiniWidgetPath__}';

function __gzlCall__(module, method, params, success, fail) {
    if (method.endsWith('Sync')) {
      const res = window.widgetView.callNativeSync(__MiniAppId__, __MiniWidgetPath__, module, method, params);
      return res;
    }
    __widgetCallbackNum__ = __widgetCallbackNum__ + 1;
    if(__widgetCallbackNum__ > 2147483647) {
    	    __widgetCallbackNum__ = 1;
    }
    __widgetSuccessCallbackMap__[__widgetCallbackNum__] = success;
    __widgetFailCallbackMap__[__widgetCallbackNum__] = fail;
    window.widgetView.callNativeAsync(__MiniAppId__, __MiniWidgetPath__, module, method, params, __widgetCallbackNum__);
}
window.gzlJSBridge.call = __gzlCall__;

function __apiWidgetSuccessCallback__(callbackId, result) {
	if (result == undefined || result == "undefined" || result == null) {
	    result = {};
	}
	if (__widgetSuccessCallbackMap__[callbackId]) {
		__widgetSuccessCallbackMap__[callbackId](result);
		delete __widgetSuccessCallbackMap__[callbackId];
		delete __widgetFailCallbackMap__[callbackId];
	}
}
window.gzlJSBridge.apiWidgetSuccessCallback = __apiWidgetSuccessCallback__;

function __apiWidgetFailCallback__(callbackId, result) {
	if (result == undefined || result == "undefined" || result == null) {
	    result = {};
	}
	if (__widgetFailCallbackMap__[callbackId]) {
		__widgetFailCallbackMap__[callbackId](result);
		delete __widgetFailCallbackMap__[callbackId];
		delete __widgetSuccessCallbackMap__[callbackId];
	}
}
window.gzlJSBridge.apiWidgetFailCallback = __apiWidgetFailCallback__;

function __WidgetInvoke__(name, type, params) {
    if (name == undefined || name == "undefined" || name == null) {
	    name = '';
	}
	if (type == undefined || type == "undefined" || type == null) {
    	type = '';
    }
    if (params == undefined || params == "undefined" || params == null) {
        params = '';
    }
    window.widgetView.widgetInvoke(__MiniAppId__, __MiniWidgetPath__, name, type, params);
}
window.gzlJSBridge.widgetInvoke = __WidgetInvoke__;

function __WidgetOnError__(message, source, lineno, colno, error) {
    if (message == undefined || message == "undefined" || message == null) {
	    message = '';
	}
	if (source == undefined || source == "undefined" || source == null) {
    	source = '';
    }
    if (error == undefined || error == "undefined" || error == null) {
        error = '';
    }
    if (lineno == undefined || lineno == null) {
        lineno = 0;
    }
    if (colno == undefined || colno == null) {
        colno = 0;
    }
    return window.widgetView.onError(__MiniAppId__, __MiniWidgetPath__, message, source, lineno, colno, JSON.stringify(error));
}
window.onerror = __WidgetOnError__;

const globalHandlers = [];
function __widget_global_eventhandler__(func) {
	globalHandlers.push(func);
}
window.setGlobalGZLEventHandler = __widget_global_eventhandler__;

function __widget_event_callback__(eventName, args, taskId) {
	for(const f of globalHandlers) {
    	f(eventName, args, taskId)
    }
}
window.gzlJSBridge.apiWidgetEventCallback = __widget_event_callback__;