# This is an example repo for Koin [Issue#2221](https://github.com/InsertKoinIO/koin/issues/2221#issuecomment-2989108497)

The app will crash on iOS after triggering a compose configuration change like rotation or toggling dark mode. 

### Error:
```
Uncaught Kotlin exception: org.koin.core.error.ClosedScopeException: Scope '_root_' is closed
    at 0   koinissue2221.debug.dylib           0x1067eabd7        kfun:kotlin.Throwable#<init>(kotlin.String?){} + 99 
    at 1   koinissue2221.debug.dylib           0x1067e4d23        kfun:kotlin.Exception#<init>(kotlin.String?){} + 95 
    at 2   koinissue2221.debug.dylib           0x1070c6ebf        kfun:org.koin.core.error.ClosedScopeException#<init>(kotlin.String){} + 95 
    at 3   koinissue2221.debug.dylib           0x1070dd143        kfun:org.koin.core.scope.Scope.resolveInstance#internal + 659 
    at 4   koinissue2221.debug.dylib           0x1070dc707        kfun:org.koin.core.scope.Scope.resolve#internal + 1019 
    at 5   koinissue2221.debug.dylib           0x1070dc053        kfun:org.koin.core.scope.Scope#get(kotlin.reflect.KClass<*>;org.koin.core.qualifier.Qualifier?;kotlin.Function0<org.koin.core.parameter.ParametersHolder>?){0§<kotlin.Any?>}0:0 + 323 
    at 6   koinissue2221.debug.dylib           0x1070dc1ef        kfun:org.koin.core.scope.Scope#get$default(kotlin.reflect.KClass<*>;org.koin.core.qualifier.Qualifier?;kotlin.Function0<org.koin.core.parameter.ParametersHolder>?;kotlin.Int){0§<kotlin.Any?>}0:0 + 339
```
