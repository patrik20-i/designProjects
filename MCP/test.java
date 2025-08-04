package MCP;

import java.util.*;
import java.util.concurrent.CompletableFuture;

/**
 * MCP (Model Context Protocol) Basic Implementation
 * This demonstrates core MCP concepts including servers, clients, and tools
 */
public class test {
    
    public static void main(String[] args) {
        // Create MCP server and client
        MCPServer server = new MCPServer();
        MCPClient client = new MCPClient(server);
        
        // Register some tools
        server.registerTool(new CalculatorTool());
        server.registerTool(new FileSystemTool());
        
        // Demonstrate basic MCP operations
        demonstrateToolCalls(client);
        demonstrateResourceAccess(client);
    }
    
    private static void demonstrateToolCalls(MCPClient client) {
        System.out.println("=== MCP Tool Calls Demo ===");
        
        // Call calculator tool
        ToolCallRequest calcRequest = new ToolCallRequest("calculator", "add", 
            Map.of("a", 10, "b", 20));
        ToolCallResponse calcResponse = client.callTool(calcRequest);
        System.out.println("Calculator result: " + calcResponse.getResult());
        
        // Call file system tool
        ToolCallRequest fileRequest = new ToolCallRequest("filesystem", "list_files", 
            Map.of("path", "."));
        ToolCallResponse fileResponse = client.callTool(fileRequest);
        System.out.println("Files: " + fileResponse.getResult());
    }
    
    private static void demonstrateResourceAccess(MCPClient client) {
        System.out.println("\n=== MCP Resource Access Demo ===");
        
        ResourceRequest request = new ResourceRequest("file://./README.md");
        ResourceResponse response = client.getResource(request);
        System.out.println("Resource content preview: " + 
            response.getContent().substring(0, Math.min(100, response.getContent().length())));
    }
}

/**
 * Core MCP Server implementation
 */
class MCPServer {
    private Map<String, MCPTool> tools = new HashMap<>();
    private Map<String, String> resources = new HashMap<>();
    
    public void registerTool(MCPTool tool) {
        tools.put(tool.getName(), tool);
        System.out.println("Registered tool: " + tool.getName());
    }
    
    public ToolCallResponse executeTool(ToolCallRequest request) {
        MCPTool tool = tools.get(request.getToolName());
        if (tool == null) {
            return new ToolCallResponse(false, "Tool not found: " + request.getToolName(), null);
        }
        
        try {
            Object result = tool.execute(request.getFunctionName(), request.getParameters());
            return new ToolCallResponse(true, "Success", result);
        } catch (Exception e) {
            return new ToolCallResponse(false, "Error: " + e.getMessage(), null);
        }
    }
    
    public ResourceResponse getResource(ResourceRequest request) {
        // Simple file resource handler
        try {
            String content = "Sample resource content for: " + request.getUri();
            return new ResourceResponse(true, content, "text/plain");
        } catch (Exception e) {
            return new ResourceResponse(false, "Error loading resource", "text/plain");
        }
    }
    
    public List<String> listTools() {
        return new ArrayList<>(tools.keySet());
    }
}

/**
 * MCP Client for communicating with server
 */
class MCPClient {
    private MCPServer server;
    
    public MCPClient(MCPServer server) {
        this.server = server;
    }
    
    public ToolCallResponse callTool(ToolCallRequest request) {
        return server.executeTool(request);
    }
    
    public ResourceResponse getResource(ResourceRequest request) {
        return server.getResource(request);
    }
    
    public List<String> getAvailableTools() {
        return server.listTools();
    }
}

/**
 * Base interface for MCP tools
 */
interface MCPTool {
    String getName();
    String getDescription();
    Object execute(String function, Map<String, Object> parameters) throws Exception;
    List<String> getSupportedFunctions();
}

/**
 * Example Calculator Tool
 */
class CalculatorTool implements MCPTool {
    @Override
    public String getName() {
        return "calculator";
    }
    
    @Override
    public String getDescription() {
        return "Basic mathematical operations";
    }
    
    @Override
    public Object execute(String function, Map<String, Object> parameters) throws Exception {
        switch (function) {
            case "add":
                Number a = (Number) parameters.get("a");
                Number b = (Number) parameters.get("b");
                return a.doubleValue() + b.doubleValue();
            case "multiply":
                Number x = (Number) parameters.get("x");
                Number y = (Number) parameters.get("y");
                return x.doubleValue() * y.doubleValue();
            default:
                throw new IllegalArgumentException("Unknown function: " + function);
        }
    }
    
    @Override
    public List<String> getSupportedFunctions() {
        return Arrays.asList("add", "multiply");
    }
}

/**
 * Example File System Tool
 */
class FileSystemTool implements MCPTool {
    @Override
    public String getName() {
        return "filesystem";
    }
    
    @Override
    public String getDescription() {
        return "File system operations";
    }
    
    @Override
    public Object execute(String function, Map<String, Object> parameters) throws Exception {
        switch (function) {
            case "list_files":
                String path = (String) parameters.get("path");
                return Arrays.asList("file1.txt", "file2.java", "directory1/");
            case "read_file":
                String filePath = (String) parameters.get("path");
                return "Sample file content for: " + filePath;
            default:
                throw new IllegalArgumentException("Unknown function: " + function);
        }
    }
    
    @Override
    public List<String> getSupportedFunctions() {
        return Arrays.asList("list_files", "read_file");
    }
}

// Data classes for MCP communication
class ToolCallRequest {
    private String toolName;
    private String functionName;
    private Map<String, Object> parameters;
    
    public ToolCallRequest(String toolName, String functionName, Map<String, Object> parameters) {
        this.toolName = toolName;
        this.functionName = functionName;
        this.parameters = parameters;
    }
    
    // Getters
    public String getToolName() { return toolName; }
    public String getFunctionName() { return functionName; }
    public Map<String, Object> getParameters() { return parameters; }
}

class ToolCallResponse {
    private boolean success;
    private String message;
    private Object result;
    
    public ToolCallResponse(boolean success, String message, Object result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }
    
    // Getters
    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public Object getResult() { return result; }
}

class ResourceRequest {
    private String uri;
    
    public ResourceRequest(String uri) {
        this.uri = uri;
    }
    
    public String getUri() { return uri; }
}

class ResourceResponse {
    private boolean success;
    private String content;
    private String mimeType;
    
    public ResourceResponse(boolean success, String content, String mimeType) {
        this.success = success;
        this.content = content;
        this.mimeType = mimeType;
    }
    
    // Getters
    public boolean isSuccess() { return success; }
    public String getContent() { return content; }
    public String getMimeType() { return mimeType; }
}
