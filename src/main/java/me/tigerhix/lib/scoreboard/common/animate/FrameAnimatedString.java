package me.tigerhix.lib.scoreboard.common.animate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrameAnimatedString implements AnimatableString {

    protected List<String> frames = new ArrayList<>();
    protected int currentFrame = -1;

    public FrameAnimatedString() {
    }

    public FrameAnimatedString(String... frames) {
        this.frames = Arrays.asList(frames);
    }

    public FrameAnimatedString(List<String> frames) {
        this.frames = frames;
    }

    public void addFrame(String string) {
        frames.add(string);
    }

    public void setFrame(int frame, String string) {
        frames.set(frame, string);
    }

    public void removeFrame(String string) {
        frames.remove(string);
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public int getTotalLength() {
        return frames.size();
    }

    public String getString(int frame) {
        return frames.get(frame);
    }

    @Override
    public String current() {
        if (currentFrame == -1) return null;
        return frames.get(currentFrame);
    }

    @Override
    public String next() {
        currentFrame++;
        if (currentFrame == frames.size()) currentFrame = 0;
        return frames.get(currentFrame);
    }

    @Override
    public String previous() {
        currentFrame--;
        if (currentFrame == -1) currentFrame = frames.size() - 1;
        return frames.get(currentFrame);
    }

}
