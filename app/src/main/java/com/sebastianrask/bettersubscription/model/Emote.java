package com.sebastianrask.bettersubscription.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by Sebastian Rask Jepsen on 28/07/16.
 */
public class Emote implements Comparable<Emote>, Serializable {
	private String emoteId, emoteKeyword;
	private boolean isBetterTTVEmote, isFfzEmote, isTextEmote, isSubscriberEmote, isBetterTTVChannelEmote, isFfzChannelEmote;
	private int maxSize;

	public Emote(String emoteId, String emoteKeyword, boolean isBetterTTVEmote, boolean isFfzEmote) {
		this.emoteId = emoteId;
		this.emoteKeyword = emoteKeyword;
		this.isBetterTTVEmote = isBetterTTVEmote;
		this.isFfzEmote = isFfzEmote;
		this.isTextEmote = false;
		this.maxSize = 4;
	}

	public Emote(String textEmoteUnicode) {
		emoteKeyword = textEmoteUnicode;
		isTextEmote = true;
	}

	public boolean isBetterTTVChannelEmote() {
		return isBetterTTVChannelEmote;
	}

	public boolean isFfzChannelEmote() {
		return isFfzChannelEmote;
	}

	public void setBetterTTVChannelEmote(boolean betterTTVChannelEmote) {
		isBetterTTVChannelEmote = betterTTVChannelEmote;
	}

	public void setFfzChannelEmote(boolean ffzChannelEmote) {
		isFfzChannelEmote = ffzChannelEmote;
	}

	public boolean isSubscriberEmote() {
		return isSubscriberEmote;
	}

	public void setSubscriberEmote(boolean subscriberEmote) {
		isSubscriberEmote = subscriberEmote;
	}

	public String getEmoteId() {
		return emoteId;
	}

	public void setEmoteId(String emoteId) {
		this.emoteId = emoteId;
	}

	public boolean isBetterTTVEmote() {
		return isBetterTTVEmote;
	}

	public void setBetterTTVEmote(boolean betterTTVEmote) {
		isBetterTTVEmote = betterTTVEmote;
	}

	public boolean isFfzEmote() {
		return isFfzEmote;
	}

	public void setFfzEmote(boolean ffzEmote) {
		isFfzEmote = ffzEmote;
	}

	public boolean isTextEmote() {
		return isTextEmote;
	}

	public void setTextEmote(boolean textEmote) {
		isTextEmote = textEmote;
	}

	public String getKeyword() {
		return emoteKeyword;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public int getMaxSize() {
		return maxSize;
	}

	@Override
	public int compareTo(@NonNull Emote emote) {
		if ((this.isBetterTTVChannelEmote() && !emote.isBetterTTVChannelEmote()) ||
			(this.isFfzChannelEmote() && !emote.isFfzChannelEmote()) ||
			(this.isBetterTTVEmote() && !emote.isBetterTTVEmote()) ||
			(this.isFfzEmote() && !emote.isFfzEmote())) {
			return -1;
		} else if ((emote.isBetterTTVChannelEmote() && !this.isBetterTTVChannelEmote()) ||
			(emote.isFfzChannelEmote() && !this.isFfzChannelEmote()) ||
			(emote.isBetterTTVEmote() && !this.isBetterTTVEmote()) ||
			(emote.isFfzEmote() && !this.isFfzEmote())) {
			return 1;
		} else {
			return this.emoteKeyword.compareTo(emote.emoteKeyword);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Emote emote = (Emote) o;

		if (isBetterTTVEmote != emote.isBetterTTVEmote) return false;
		if (isFfzEmote != emote.isFfzEmote) return false;
		if (isTextEmote != emote.isTextEmote) return false;
		if (maxSize != emote.maxSize) return false;
		if (emoteId != null ? !emoteId.equals(emote.emoteId) : emote.emoteId != null) return false;
		return emoteKeyword != null ? emoteKeyword.equals(emote.emoteKeyword) : emote.emoteKeyword == null;
	}

	@Override
	public int hashCode() {
		int result = emoteId != null ? emoteId.hashCode() : 0;
		result = 31 * result + (emoteKeyword != null ? emoteKeyword.hashCode() : 0);
		result = 31 * result + (isBetterTTVEmote ? 1 : 0);
		result = 31 * result + (isFfzEmote ? 1 : 0);
		result = 31 * result + (isTextEmote ? 1 : 0);
		result = 31 * result + maxSize;
		return result;
	}
}
