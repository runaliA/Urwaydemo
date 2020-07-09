package in.concerto.urway.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * This class echoes a string called from JavaScript.
 */
public class UrwayCustomplugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if(action.equals("payment"))
        {
            this.payment(args,callbackContext);
            return true;
        }
        return false;
    }

    


    private void payment(JSONArray args,CallbackContext callbackContext)
    {
        if(args != null)
        {

            try
            {
                    int p1=Integer.parseInt(args.getJSONObject(0).getString("param1"));
                    int p2=Integer.parseInt(args.getJSONObject(0).getString("param2"));
            callbackContext.success("RESULT is "+(p1+p2));
            }
            catch(Exception ex)
            {
                callbackContext.error("Exception "+ ex);
            }
        }
        else
        {
            callbackContext.error("Please pass some value");
        }

    }
}
