package ru.msk.tkachenko.dmitry.web.webnote.error;

public class UserNotFoundException extends RuntimeException {
	
	private long userId;

	public UserNotFoundException(Long userId) {
		this.userId = userId;
	}
	
	public long getUserId() {
		return userId;
	}
}
