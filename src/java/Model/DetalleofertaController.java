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

@Named("detalleofertaController")
@SessionScoped
public class DetalleofertaController implements Serializable {

    private Detalleoferta current;
    private DataModel items = null;
    @EJB
    private Model.DetalleofertaFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public DetalleofertaController() {
    }

    public Detalleoferta getSelected() {
        if (current == null) {
            current = new Detalleoferta();
            current.setDetalleofertaPK(new Model.DetalleofertaPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private DetalleofertaFacade getFacade() {
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
        current = (Detalleoferta) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Detalleoferta();
        current.setDetalleofertaPK(new Model.DetalleofertaPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getDetalleofertaPK().setNombreoferente(current.getOferta().getOfertaPK().getNombreoferente());
            current.getDetalleofertaPK().setCodigoproceso(current.getOferta().getOfertaPK().getCodigoproceso());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DetalleofertaCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Detalleoferta) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getDetalleofertaPK().setNombreoferente(current.getOferta().getOfertaPK().getNombreoferente());
            current.getDetalleofertaPK().setCodigoproceso(current.getOferta().getOfertaPK().getCodigoproceso());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DetalleofertaUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Detalleoferta) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DetalleofertaDeleted"));
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

    public Detalleoferta getDetalleoferta(Model.DetalleofertaPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Detalleoferta.class)
    public static class DetalleofertaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DetalleofertaController controller = (DetalleofertaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "detalleofertaController");
            return controller.getDetalleoferta(getKey(value));
        }

        Model.DetalleofertaPK getKey(String value) {
            Model.DetalleofertaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new Model.DetalleofertaPK();
            key.setNombreoferente(values[0]);
            key.setCodigoproceso(values[1]);
            key.setRubro(values[2]);
            return key;
        }

        String getStringKey(Model.DetalleofertaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getNombreoferente());
            sb.append(SEPARATOR);
            sb.append(value.getCodigoproceso());
            sb.append(SEPARATOR);
            sb.append(value.getRubro());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Detalleoferta) {
                Detalleoferta o = (Detalleoferta) object;
                return getStringKey(o.getDetalleofertaPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Detalleoferta.class.getName());
            }
        }

    }

}
