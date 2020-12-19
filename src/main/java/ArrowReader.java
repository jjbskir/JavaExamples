import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.types.pojo.Field;

import java.util.List;

public class ArrowReader {
    public void read(VectorSchemaRoot root) {
        // iterate through
        List<Field> fields = root.getSchema().getFields();
//        fields.stream().map(field -> {
//            field.get
//        });
//        fields.size()
//        Field field = fields.get(0);
//        root.getVector(fields.get(0).getName())
//        IntVector intVector = (IntVector) root.getVector(fields.get(0).getName());
//        intVector.get(0)

    }

    public void schema() {
        //        ImmutableList.Builder<Field> childrenBuilder = ImmutableList.builder();
//        childrenBuilder.add(new Field("int", FieldType.nullable(new ArrowType.Int(32, true)), null));
//        childrenBuilder.add(new Field("long", FieldType.nullable(new ArrowType.Int(64, true)), null));
//        Schema schema = new Schema(childrenBuilder.build(), null);
//        VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator);

        //        List<Field> fields = root.getSchema().getFields();
//        IntVector intVector = (IntVector) root.getVector(fields.get(0).getName());
//        BigIntVector intVector = (BigIntVector) root.getVector(fields.get(0).getName());
        //        int Vector.get(0)
    }

}
