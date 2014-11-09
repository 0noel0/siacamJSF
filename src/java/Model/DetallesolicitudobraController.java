package Model;

import Model.util.JsfUtil;
import Model.util.PaginationHelper;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("detallesolicitudobraController")
@SessionScoped
public class DetallesolicitudobraController implements Serializable {

    private Detallesolicitudobra current;
    private DataModel items = null;
    @EJB
    private Model.DetallesolicitudobraFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public DetallesolicitudobraController() {
    }

    public Detallesolicitudobra getSelected() {
        if (current == null) {
            current = new Detallesolicitudobra();
            current.setDetallesolicitudobraPK(new Model.DetallesolicitudobraPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private DetallesolicitudobraFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Detallesolicitudobra) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Detallesolicitudobra();
        current.setDetallesolicitudobraPK(new Model.DetallesolicitudobraPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getDetallesolicitudobraPK().setFecha(current.getSolicitudobra().getSolicitudobraPK().getFecha());
            current.getDetallesolicitudobraPK().setNombresolicitante(current.getSolicitudobra().getSolicitudobraPK().getNombresolicitante());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DetallesolicitudobraCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Detallesolicitudobra) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getDetallesolicitudobraPK().setFecha(current.getSolicitudobra().getSolicitudobraPK().getFecha());
            current.getDetallesolicitudobraPK().setNombresolicitante(current.getSolicitudobra().getSolicitudobraPK().getNombresolicitante());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DetallesolicitudobraUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Detallesolicitudobra) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DetallesolicitudobraDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Detallesolicitudobra getDetallesolicitudobra(Model.DetallesolicitudobraPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Detallesolicitudobra.class)
    public static class DetallesolicitudobraControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DetallesolicitudobraController controller = (DetallesolicitudobraController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "detallesolicitudobraController");
            return controller.getDetallesolicitudobra(getKey(value));
        }

        Model.DetallesolicitudobraPK getKey(String value) {
            Model.DetallesolicitudobraPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new Model.DetallesolicitudobraPK();
            key.setItem(Integer.parseInt(values[0]));
            key.setFecha(java.sql.Date.valueOf(values[1]));
            key.setNombresolicitante(values[2]);
            return key;
        }

        String getStringKey(Model.DetallesolicitudobraPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getItem());
            sb.append(SEPARATOR);
            sb.append(value.getFecha());
            sb.append(SEPARATOR);
            sb.append(value.getNombresolicitante());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Detallesolicitudobra) {
                Detallesolicitudobra o = (Detallesolicitudobra) object;
                return getStringKey(o.getDetallesolicitudobraPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Detallesolicitudobra.class.getName());
            }
        }

    }

}
