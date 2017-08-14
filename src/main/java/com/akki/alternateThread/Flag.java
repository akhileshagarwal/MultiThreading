package com.akki.alternateThread;

public class Flag {
private boolean isProcessedByA=Boolean.FALSE;
private boolean isProcessedByB=Boolean.FALSE;
public boolean isProcessedByA() {
	return isProcessedByA;
}
public void setProcessedByA(boolean isProcessedByA) {
	this.isProcessedByA = isProcessedByA;
}
public boolean isProcessedByB() {
	return isProcessedByB;
}
public void setProcessedByB(boolean isProcessedByB) {
	this.isProcessedByB = isProcessedByB;
}
}
