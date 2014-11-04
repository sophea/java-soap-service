package com.sma.soap;

import java.io.IOException;

import org.springframework.ws.transport.TransportInputStream;

public interface SoapProtocolChooser {

public boolean useSoap11(TransportInputStream transportInputStream) throws IOException;
}
