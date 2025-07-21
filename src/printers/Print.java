package printers;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class Print {
	

	public static void Array(Object arr) {
	
	    if (!arr.getClass().isArray()) return;
	
	    int dimension = 0;
	    Class<?> clazz = arr.getClass();
	    while (clazz.isArray()) {
	        dimension++;
	        clazz = clazz.getComponentType();
	    }
	
	    if (dimension == 1) {
	    	
	        int len = Array.getLength(arr);
	        String result = IntStream.range(0, len)
	            .mapToObj(i -> String.valueOf(Array.get(arr, i)))
	            .collect(Collectors.joining(", ", "{ ", " }"));
	        System.out.print(result);
	        
	
	    } else if (dimension == 2) {
	        int rows = Array.getLength(arr);
	        IntStream.range(0, rows).
	        	forEach(i -> {
		            Object row = Array.get(arr, i);
		            int cols = Array.getLength(row);
		            String linha = IntStream.range(0, cols)
		                .mapToObj(j -> String.valueOf(Array.get(row, j)))
		                .collect(Collectors.joining(", ", "{ ", " }"));
		            System.out.print(linha);
	        	});
	    }
	}
	
	public static void Array(Iterable<?> list) {
	    String result = "{ " + 
	        String.join(", ", 
	            StreamSupport.stream(list.spliterator(), false)
	                         .map(Object::toString)
	                         .toList()
	        ) + 
	    " }";
	    System.out.print(result);
	}
	
	public static void Map(Map<?, ?> map) {
	    System.out.println("{");
	    int count = 0;
	    int size = map.size();
	    for (Map.Entry<?, ?> entry : map.entrySet()) {
	        String key = String.valueOf(entry.getKey());
	        String value = formatValue(entry.getValue());
	        System.out.print("  \"" + key + "\": " + value);
	        if (++count < size) System.out.print(",");
	        System.out.println();
	    }
	    System.out.println("}");
	}

	private static String formatValue(Object value) {
	    if (value instanceof String) {
	        return "\"" + value + "\"";
	    } else if (value instanceof Map) {
	        return formatNestedMap((Map<?, ?>) value, 2);
	    } else {
	        return String.valueOf(value);
	    }
	}

	private static String formatNestedMap(Map<?, ?> map, int indentLevel) {
	    StringBuilder sb = new StringBuilder();
	    String indent = "  ".repeat(indentLevel);
	    String innerIndent = "  ".repeat(indentLevel + 1);
	    sb.append("{\n");
	    int count = 0;
	    int size = map.size();
	    for (Map.Entry<?, ?> entry : map.entrySet()) {
	        sb.append(innerIndent)
	          .append("\"").append(entry.getKey()).append("\": ")
	          .append(formatValue(entry.getValue()));
	        if (++count < size) sb.append(",");
	        sb.append("\n");
	    }
	    sb.append(indent).append("}");
	    return sb.toString();
	}
	
	
}
