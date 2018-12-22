package dto;

import java.io.*;
import java.util.LinkedList;

/**
 *
 * @author Thibault Debatty
 * @param <T> The type of items in this dataset
 */
public abstract class Dataset<T> implements Iterable<T>, Serializable {

    /**
     * Return all items of the dataset (except if it's an infinite dataset).
     * @return
     */
    public LinkedList<T> getAll() {
        LinkedList<T> list = new LinkedList<T>();
        for (T item : this) {
            list.add(item);
        }
        return list;
    }

    /**
     * Get the first items of the dataset.
     * @param count
     * @return
     */
    public final LinkedList<T> get(int count) {
        LinkedList<T> list = new LinkedList<T>();
        for (T item : this) {
            list.add(item);
            if (list.size() == count) {
                return list;
            }
        }
        return list;
    }


    /**
     * Serialize and save this dataset to an output stream (might be a file).
     * The java Dataset class gets serialized and saved, not the actual
     * elements of the dataset.
     * @param out
     * @throws IOException if output file does not exist
     */
    public final void save(final OutputStream out) throws IOException {
        ObjectOutputStream object_out = new ObjectOutputStream(out);
        object_out.writeObject(this);
    }

    /**
     * Load a saved dataset.
     *
     * @param input
     * @return
     * @throws IOException if file does not exist
     * @throws ClassNotFoundException if class is not recognized
     */
    public static Dataset load(final InputStream input)
            throws IOException, ClassNotFoundException {
        ObjectInputStream object_input = new ObjectInputStream(input);
        Dataset dataset = (Dataset) object_input.readObject();
        return dataset;
    }
}
