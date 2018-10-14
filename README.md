# Cordova Get Android PID Plugin

Simple plugin that returns your the current android process id.
    
## Installation

    $ cordova plugin add https://github.com/terpro/cordova-plugin-getpid.git
    

## Usage
	
getpid.pid availible after `onDeviceReady`

```js
    getpid.pid(appendProcStartTime, successCallback, errorCallback);
```

### Parameters

appendProcStartTime: (true or false) Also return the android getStartElapsedRealtime value. Useful because PIDs can be resued.

successCallback: (function) Will return process id

errorCallback: (function) I don't imagine you'll get any errors.. but just in case

### Example code

```js
    var success = function(pid) {
        alert(pid);
    }

    var error = function() {
        alert("Something has gone horribly wrong");
    }

    getpid.pid(true, success, error);
```

Example PID: 7829
Example PID with procStartTime appended: 7829-1089503499