package com.mygdx.game;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.pay.PurchaseManager;
import com.badlogic.gdx.pay.PurchaseManagerConfig;
import com.badlogic.gdx.pay.PurchaseObserver;
import com.badlogic.gdx.pay.Transaction;
import com.badlogic.gdx.pay.android.googlebilling.PurchaseManagerGoogleBilling;
import com.mygdx.game.MyGdxGame;

public class AndroidLauncher extends AndroidApplication {

	private PurchaseManager _PurchaseManager;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new MyGdxGame(), config);
		InitializePurchaseManager();

	}

	@Override
	protected void onDestroy() {
		_PurchaseManager.dispose();
		super.onDestroy();
	}

	private void InitializePurchaseManager() {
		PurchaseManager purchaseManager = new PurchaseManagerGoogleBilling(this);
		PurchaseManagerConfig purchaseManagerConfig = new PurchaseManagerConfig();
		purchaseManager.install(new PurchaseObserver() {
			@Override
			public void handleInstall() {

			}

			@Override
			public void handleInstallError(Throwable e) {

			}

			@Override
			public void handleRestore(Transaction[] transactions) {

			}

			@Override
			public void handleRestoreError(Throwable e) {

			}

			@Override
			public void handlePurchase(Transaction transaction) {

			}

			@Override
			public void handlePurchaseError(Throwable e) {

			}

			@Override
			public void handlePurchaseCanceled() {

			}
		}, purchaseManagerConfig, true);
		_PurchaseManager = purchaseManager;
	}
}
