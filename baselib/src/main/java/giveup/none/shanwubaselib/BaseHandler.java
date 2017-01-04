package giveup.none.shanwubaselib;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Created by shanwu on 17-1-5.
 */

public class BaseHandler extends Handler {
    WeakReference<Callback> mTarget = null;

    public BaseHandler(Callback cb) {
        mTarget = new WeakReference<>(cb);
    }

    public interface Callback {
        boolean handleMessage(Message msg);
    }

    @Override
    public void handleMessage(Message msg) {
        Callback handler = mTarget.get();

        if (handler != null) {
            handler.handleMessage(msg);
        }
    }
}
