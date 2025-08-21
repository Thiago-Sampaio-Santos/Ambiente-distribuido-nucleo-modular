package br.ifba.saj.ads10.rmiimpl;

import br.ifba.saj.ads10.core.AuthToken;
import br.ifba.saj.ads10.core.LamportClock;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class RmiServiceImpl extends UnicastRemoteObject implements RmiService {
    private final LamportClock clock; private final AuthToken auth;
    public RmiServiceImpl(LamportClock clock, String secret) throws RemoteException {
        super(); this.clock=clock; this.auth = new AuthToken(secret);
    }
    @Override public String ping(String token, long lamport) throws RemoteException {
        if (!auth.valide(token)) throw new RemoteException("não autorizado");
        clock.recv(lamport); return "pong:" + clock.now();
    }
    @Override public String event(String token, long lamport, String payload) throws RemoteException {
        if (!auth.valide(token)) throw new RemoteException("não autorizado");
        clock.recv(lamport); return "ack:" + clock.now();
    }
}
