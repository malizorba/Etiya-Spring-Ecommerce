package com.etiya.ecommercedemopair3.core.util.messages;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessagesSourceManager implements MessageSourceService{
    private MessageSource messageSource;
    @Override
    public String getMessages(String message) {
        return messageSource.getMessage(message,null, LocaleContextHolder.getLocale());
    }
}
