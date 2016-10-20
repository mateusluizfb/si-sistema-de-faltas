package si.jsf;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import si.entities.Membro;
import si.entities.Presenca;
import si.enums.TipoPresenca;
import si.repositories.MembroRepository;
import si.repositories.TurmaRepository;
import si.util.FacesUtil;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by mateus on 20/10/16.
 */

@Component
@RequestScope
public class GraficoBean {

    @Autowired
    private TurmaRepository tr;

    @Autowired
    private MembroRepository mr;

    private LineChartModel animatedChart;

    public LineChartModel getAnimatedChart(){
        createAnimatedChart(Long.valueOf(FacesUtil.getParameter("id")));
        return animatedChart;
    }

    private void createAnimatedChart(Long id){
        animatedChart = initiChart(id);
        animatedChart.setTitle("Faltas");
        animatedChart.setAnimate(true);
        animatedChart.setLegendPosition("se");
        Axis yAxis = animatedChart.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(3);
    }

    private LineChartModel initiChart(Long id){
        LineChartModel chart = new LineChartModel();
        LineChartSeries member;

        member = new LineChartSeries();
        member.setLabel("oi");
        member.set(1,2);
        member.set(2,1);

        chart.addSeries(member);

        return chart;
    }

    public TurmaRepository getTr() {
        return tr;
    }

    public void setTr(TurmaRepository tr) {
        this.tr = tr;
    }

    public MembroRepository getMr() {
        return mr;
    }

    public void setMr(MembroRepository mr) {
        this.mr = mr;
    }
}
