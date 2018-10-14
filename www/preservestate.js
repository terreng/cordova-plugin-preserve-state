/*global cordova, module*/

module.exports = {
    setState: function (state, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Preservestate", "setState", [state]);
    },
    getState: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Preservestate", "getState", ["param"]);
    }
};