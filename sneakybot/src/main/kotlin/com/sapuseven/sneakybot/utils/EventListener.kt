package com.sapuseven.sneakybot.utils

import com.github.theholywaffle.teamspeak3.api.event.*
import com.sapuseven.sneakybot.SneakyBot

class EventListenerImplementation(private val bot: SneakyBot) : TS3Listener {
    override fun onTextMessage(e: TextMessageEvent) {
        sendEventToServices(e)
    }

    override fun onServerEdit(e: ServerEditedEvent) {
        sendEventToServices(e)
    }

    override fun onClientMoved(e: ClientMovedEvent) {
        sendEventToServices(e)
    }

    override fun onClientLeave(e: ClientLeaveEvent) {
        sendEventToServices(e)
    }

    override fun onClientJoin(e: ClientJoinEvent) {
        sendEventToServices(e)
    }

    override fun onChannelEdit(e: ChannelEditedEvent) {
        sendEventToServices(e)
    }

    override fun onChannelDescriptionChanged(e: ChannelDescriptionEditedEvent) {
        sendEventToServices(e)
    }

    override fun onChannelCreate(e: ChannelCreateEvent) {
        sendEventToServices(e)
    }

    override fun onChannelDeleted(e: ChannelDeletedEvent) {
        sendEventToServices(e)
    }

    override fun onChannelMoved(e: ChannelMovedEvent) {
        sendEventToServices(e)
    }

    override fun onChannelPasswordChanged(e: ChannelPasswordChangedEvent) {
        sendEventToServices(e)
    }

    override fun onPrivilegeKeyUsed(e: PrivilegeKeyUsedEvent) {
        sendEventToServices(e)
    }

    private fun sendEventToServices(e: BaseEvent) {
        for (p in bot.services + bot.builtinServices)
            p.onEventReceived(e)
    }
}
