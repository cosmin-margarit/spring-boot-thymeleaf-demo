package com.cosmin.web;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.Serializable;

public class FlashMessage implements Serializable {
    public static final String FLASH_KEY = "notification";
    private String title;
    private String message;
    private Type type;

    public static void ok(RedirectAttributes redirectAttributes, String title, String message) {
        bind(redirectAttributes, ok(title, message));
    }

    public static void ok(RedirectAttributes redirectAttributes, String message) {
        bind(redirectAttributes, ok(message));
    }

    public static FlashMessage ok(String title, String message) {
        return build(title, message, Type.SUCCESS);
    }

    public static FlashMessage ok(String message) {
        return build(null, message, Type.SUCCESS);
    }

    public static void error(RedirectAttributes redirectAttributes, String title, String message) {
        bind(redirectAttributes, error(title, message));
    }

    public static void error(RedirectAttributes redirectAttributes, String message) {
        bind(redirectAttributes, error(message));
    }

    public static FlashMessage error(String title, String message) {
        return build(title, message, Type.DANGER);
    }

    public static FlashMessage error(String message) {
        return build(null, message, Type.DANGER);
    }

    public static void warn(RedirectAttributes redirectAttributes, String title, String message) {
        bind(redirectAttributes, warn(title, message));
    }

    public static void warn(RedirectAttributes redirectAttributes, String message) {
        bind(redirectAttributes, warn(message));
    }

    public static FlashMessage warn(String title, String message) {
        return build(title, message, Type.WARNING);
    }

    public static FlashMessage warn(String message) {
        return build(null, message, Type.WARNING);
    }

    public static void info(RedirectAttributes redirectAttributes, String title, String message) {
        bind(redirectAttributes, info(title, message));
    }

    public static void info(RedirectAttributes redirectAttributes, String message) {
        bind(redirectAttributes, info(message));
    }

    public static FlashMessage info(String title, String message) {
        return build(title, message, Type.INFORMATION);
    }

    public static FlashMessage info(String message) {
        return build(null, message, Type.INFORMATION);
    }

    public static FlashMessage build(String title, String message, Type type) {
        FlashMessage flashMessage = new FlashMessage();
        flashMessage.setTitle(title);
        flashMessage.setMessage(message);
        flashMessage.setType(type);
        return flashMessage;
    }

    private static void bind(RedirectAttributes redirectAttributes, FlashMessage message) {
        redirectAttributes.addFlashAttribute(FLASH_KEY, true);
        redirectAttributes.addFlashAttribute(FLASH_KEY + "_title", message.getTitle());
        redirectAttributes.addFlashAttribute(FLASH_KEY + "_message", message.getMessage());
        redirectAttributes.addFlashAttribute(FLASH_KEY + "_type", message.getType().name().toLowerCase());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type implements Serializable {
        DANGER, INFORMATION, SUCCESS, WARNING
    }
}
