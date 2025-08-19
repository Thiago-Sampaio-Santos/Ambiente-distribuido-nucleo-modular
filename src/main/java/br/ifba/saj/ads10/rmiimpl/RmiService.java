package br.ifba.saj.ads10.rmiimpl;

import java.rmi.Remote; import java.rmi.RemoteException;

public interface RmiService extends Remote {
    String ping(String token, long lamport) throws RemoteException;
    String event(String token, long lamport, String payload) throws RemoteException;
}
