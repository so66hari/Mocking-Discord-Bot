require('dotenv').config();
const { token } = process.env;
const { Client, IntentsBitField } = require('discord.js');
const prefix = "pls mock ";

const client = new Client({
    intents: [
        IntentsBitField.Flags.Guilds,
        IntentsBitField.Flags.GuildMessages,
        IntentsBitField.Flags.MessageContent,
    ],
});

client.on('messageCreate', (msg) => {
    let input = msg.content;
    if(input.startsWith(prefix)) {
        input = input.replace(prefix,' ');
        input = input.toLowerCase();
        let toMock = input.split('');
        for(let i = 0; i < toMock.length; i+=2) {
            toMock[i] = toMock[i].toUpperCase();
        }
        let output = toMock.join('');
        msg.reply(output);
    }
});

client.login(token);