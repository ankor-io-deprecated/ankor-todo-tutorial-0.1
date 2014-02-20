import at.irian.ankor.ref.Ref;
import at.irian.ankor.servlet.websocket.AnkorEndpoint;
import io.ankor.tutorial.model.TaskRepository;
import io.ankor.tutorial.viewmodel.ModelRoot;

public class TodoEndpoint extends AnkorEndpoint {
    @Override
    protected Object getModelRoot(Ref rootRef) {
        return new ModelRoot(rootRef, new TaskRepository());
    }
}
