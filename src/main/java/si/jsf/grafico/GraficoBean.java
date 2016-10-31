package si.jsf.grafico;

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
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        yAxis.setMax(mr.findByTurma(id).size() + 1);
    }

    private LineChartModel initiChart(Long id){
        LineChartModel chart = new LineChartModel();
        LineChartSeries member;

        int i;

        List<Membro> membros = mr.findByTurma(id);
        List<Presenca> presencas;
        for (Membro m: membros) {
            member = new LineChartSeries();
            presencas = m.getPresencas().
                    stream().
                    filter(membro -> membro.getTurma().getId().equals(id)).
                    collect(Collectors.toList());
            i = 1;
            member.setLabel(m.getNome());
            for (Presenca p : presencas) {
                if(p.getTipoPresenca().equals(TipoPresenca.PR)){
                    member.set(i++, 1);
                }

                if(p.getTipoPresenca().equals(TipoPresenca.FL)){
                    member.set(i++, 2);
                }

                if(p.getTipoPresenca().equals(TipoPresenca.AT)){
                    member.set(i++, 3);
                }

            }
            chart.addSeries(member);
        }

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
