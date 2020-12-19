import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.complex.ListVector;
import org.apache.arrow.vector.complex.impl.UnionListReader;
import org.apache.arrow.vector.complex.impl.UnionListWriter;
import org.apache.arrow.vector.complex.reader.IntReader;

import java.util.ArrayList;

public class ArrowMain {
    public static void main(String args[]) {
        BufferAllocator allocator = new RootAllocator(Long.MAX_VALUE);

        try (ListVector listVector = ListVector.empty("listInt", allocator)) {
            listVector.allocateNew();

            // write data to vector
            // [[0, 0, 0, 0, 0], [0, 1, 2, 3, 4], [0, 2, 4, 6, 8], ..., [0, 9, 18, 27, 36]]
            UnionListWriter writer = listVector.getWriter();
            for (int i = 0; i < 10; i++) {
                writer.startList();
                writer.setPosition(i);
                for (int j = 0; j < 5; j++) {
                    writer.writeInt(j * i);
                }
                writer.setValueCount(5);
                writer.endList();
            }
            listVector.setValueCount(10);

            // access via get API
            for (int i = 0; i < listVector.getValueCount(); i++) {
                if (!listVector.isNull(i)) {
                    ArrayList<Integer> elements = (ArrayList<Integer>) listVector.getObject(i);
                    for (Integer element : elements) {
                        System.out.println(element);
                    }
                }
            }

            // access via reader
            UnionListReader reader = listVector.getReader();
            for (int i = 0; i < listVector.getValueCount(); i++) {
                reader.setPosition(i);
                while (reader.next()) {
                    IntReader intReader = reader.reader();
                    if (intReader.isSet()) {
                        System.out.println(intReader.readInteger());
                    }
                }
            }
        }
    }
}
