package br.ifba.saj.ads10.core;

import java.util.Arrays;
import java.util.List;

public record Config(
        String group, // "A" ou "B"
        int nodeId,   // unico dentro do grupo
        List<String> peers, // host:tcpPort:rmiOrGrpcPort por grupo
        String tokenSecret,
        int tcpPort,
        int grpcPort,
        int rmiPort,
        String mcastAddr,
        int mcastPort
) {
    public static Config fromEnv() {
        String group = getenv("GROUP", "A");
        int nodeId = Integer.parseInt(getenv("NODE_ID", "1"));
        String peersStr = getenv("PEERS", "");
        List<String> peers = peersStr.isBlank() ? List.of() : Arrays.asList(peersStr.split(","));
        String secret = getenv("TOKEN_SECRET", "s3cr3t");
        int tcpPort = Integer.parseInt(getenv("TCP_PORT", group.equals("A") ? "7000" : "7100"));
        int grpcPort = Integer.parseInt(getenv("GRPC_PORT", "50051"));
        int rmiPort = Integer.parseInt(getenv("RMI_PORT", "1099"));
        String mAddr = getenv("MCAST_ADDR", "230.0.0.1");
        int mPort = Integer.parseInt(getenv("MCAST_PORT", "4446"));
        return new Config(group, nodeId, peers, secret, tcpPort, grpcPort, rmiPort, mAddr, mPort);
    }
    private static String getenv(String k, String d) { String v = System.getenv(k); return v==null?d:v; }
}
