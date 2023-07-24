package greedy;

import java.util.*;

class Node implements Comparable<Node> {
    char data;
    int frequency;
    Node left;
    Node right;

    public Node(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        left = null;
        right = null;
    }

    @Override
    public int compareTo(Node other) {
        return this.frequency - other.frequency;
    }
}

public class hoffman {
    public static Map<Character, String> huffmanCodes(String S, int[] frequencies) {
        Map<Character, String> codes = new HashMap<>();

        // Step 1: Create a priority queue of nodes
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < S.length(); i++) {
            pq.add(new Node(S.charAt(i), frequencies[i]));
        }

        // Step 2: Build Huffman tree
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node('\0', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            pq.add(parent);
        }

        // Step 3: Traverse the Huffman tree and generate codes
        if (!pq.isEmpty()) {
            Node root = pq.poll();
            generateCodes(root, "", codes);
        }

        return codes;
    }

    private static void generateCodes(Node node, String code, Map<Character, String> codes) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            codes.put(node.data, code);
            return;
        }

        generateCodes(node.left, code + "0", codes);
        generateCodes(node.right, code + "1", codes);
    }

    public static void main(String[] args) {
        String S = "abcdef";
        int[] frequencies = { 5, 9, 12, 13, 16, 45 };

        Map<Character, String> huffmanCodes = huffmanCodes(S, frequencies);

        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}