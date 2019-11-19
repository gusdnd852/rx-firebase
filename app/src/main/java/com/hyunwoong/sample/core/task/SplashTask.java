package com.hyunwoong.sample.core.task;

import android.os.Handler;

import com.hyunwoong.sample.base.activity.BaseActivity;
import com.hyunwoong.sample.base.task.BaseTask;
import com.hyunwoong.sample.core.activity.SignInActivity;
import com.hyunwoong.sample.core.model.cache.UserCache;
import com.hyunwoong.sample.core.model.entity.UserEntity;
import com.hyunwoong.sample.util.Firebase;
import com.hyunwoong.sample.util.StringChecker;


/**
 * @author : Hyunwoong
 * @when : 2019-11-18 오전 11:58
 * @homepage : https://github.com/gusdnd852
 */
public class SplashTask extends BaseTask {

    public SplashTask(BaseActivity owner) {
        super(owner);
    }

    private void moveScreen() {
        new Handler().postDelayed(() ->
                moveAndFinish(SignInActivity.class), 2500);
    }

    private void processAutonomousSignIn() {
        Firebase.reference("user")
                .child(Firebase.uid())
                .access(UserEntity.class)
                .select(u -> {
                    UserCache.getInstance().copy(u); // copy to cache
                    Firebase.auth().signInWithEmailAndPassword(u.getId(), u.getPw()); // autonomous signed in
                });
    }

    public void splash() {
        String remembered = preference().getString("id", null);

        if (StringChecker.isEmpty(remembered)) moveScreen();
        else processAutonomousSignIn();
    }
}