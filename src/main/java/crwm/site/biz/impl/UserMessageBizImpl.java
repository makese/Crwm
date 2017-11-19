package crwm.site.biz.impl;

import crwm.site.biz.UserMessageBiz;
import crwm.site.dao.UserMessageDAO;
import crwm.site.pojo.UserMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserMessageBizImpl implements UserMessageBiz {

    @Resource
    private UserMessageDAO userMessageDAO;

    @Override
    public void addUserMessage(UserMessage userMessage) {
        userMessageDAO.add(userMessage);
    }

    @Override
    public void deleteUserMessage(UserMessage userMessage) {
        userMessageDAO.delete(userMessage);
    }
}
