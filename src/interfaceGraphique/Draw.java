package interfaceGraphique;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

public class Draw {
    private Graphics2D g;
    private static int radius = 20;

    public Draw(Graphics2D graphics2D){
        g = graphics2D;
    }

    public static boolean isWithinBounds(MouseEvent e, Point p) {
        int x = e.getX();
        int y = e.getY();

        int boundX = (int) p.getX();
        int boundY = (int) p.getY();

        return (x <= boundX + radius && x >= boundX - radius) && (y <= boundY + radius && y >= boundY - radius);
    }

    public static boolean isOverlapping(MouseEvent e, Point p) {
        int x = e.getX();
        int y = e.getY();

        int boundX = (int) p.getX();
        int boundY = (int) p.getY();

        return (x <= boundX + 2.5*radius && x >= boundX - 2.5*radius) && (y <= boundY + 2.5*radius && y >= boundY - 2.5*radius);
    }

    public static boolean isOnEdge(MouseEvent e, Edge edge) {

        int dist = distToSegment( e.getPoint(),
                                  edge.getNodeOne().getCoord(),
                                  edge.getNodeTwo().getCoord() );
        if (dist<6)
            return true;
        return false;
    }

    public static Color parseColor(String colorStr) {
        return new Color(
                Integer.valueOf(colorStr.substring(1, 3), 16),
                Integer.valueOf(colorStr.substring(3, 5), 16),
                Integer.valueOf(colorStr.substring(5, 7), 16));
    }

    public void drawWeight(Edge edge) {
        Point from = edge.getNodeOne().getCoord();
        Point to = edge.getNodeTwo().getCoord();
        int x = (from.x + to.x)/2;
        int y = (from.y + to.y)/2;

        int rad = radius/2;
        g.fillOval(x-rad, y-rad, 2*rad, 2*rad);
        drawWeightText(String.valueOf(edge.getWeight()), x, y);
    }

    public void drawPath(java.util.List<Node> path) {
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < path.size()-1; i++) {
            edges.add(new Edge(path.get(i), path.get(i+1)));
        }

        for(Edge edge : edges) {
            drawPath(edge);
        }
    }

    public void drawPath(Edge edge) {
        g.setColor(parseColor("#ccd400"));
        drawBoldEdge(edge);
    }

    public void drawHoveredEdge(Edge edge) {
        g.setColor(parseColor("#e7bebe"));
        drawBoldEdge(edge);
    }

    private void drawBoldEdge(Edge edge){
        Point from = edge.getNodeOne().getCoord();
        Point to = edge.getNodeTwo().getCoord();
        g.setStroke(new BasicStroke(8));
        g.drawLine(from.x, from.y, to.x, to.y);
        int x = (from.x + to.x)/2;
        int y = (from.y + to.y)/2;

        int rad = 13;
        g.fillOval(x-rad, y-rad, 2*rad, 2*rad);
    }

    public void drawEdge(Edge edge) {
        g.setColor(parseColor("#18d400"));
        drawBaseEdge(edge);
        drawWeight(edge);
    }
    


    public void drawArrow(Edge edge) {
        Graphics2D g1=g;
        Point from = edge.getNodeOne().getCoord();
        Point to = edge.getNodeTwo().getCoord();
        int x1, y1,  x2,  y2;
        x1=from.x;
        y1=from.y;
        x2=to.x-(radius/4);
        y2=to.y-radius;
        double dx = x2 - x1, dy = y1 - y2;
        double angle = Math.atan2(dy, dx);
        int len = (int) Math.sqrt(dx * dx + dy * dy);

        int p1X = (int) (x2 + Math.cos(angle + Math.PI * 3 / 4) * 8);
        int p1Y = (int) (y2 - Math.sin(angle + Math.PI * 3 / 4) * 8);
        int p2X = (int) (x2 + Math.cos(angle - Math.PI * 3 / 4) * 8);
        int p2Y = (int) (y2 - Math.sin(angle - Math.PI * 3 / 4) * 8);
        // Draw horizontal arrow starting in (0, 0)
         g1.drawLine(x1, y1, x2, y2);
        drawWeight(edge);
        Polygon polygon = new Polygon();
        polygon.addPoint(x2, y2);
        polygon.addPoint(p1X, p1Y);
        polygon.addPoint(p2X, p2Y);
        g1.setColor(parseColor("#18d400"));
        g1.fillPolygon(polygon);
    }

    private void drawBaseEdge(Edge edge){
        Point from = edge.getNodeOne().getCoord();
        Point to = edge.getNodeTwo().getCoord();
        g.setStroke(new BasicStroke(3));
        g.drawLine(from.x, from.y, to.x, to.y);
    }

    public void drawHalo(Node node){
        g.setColor(parseColor("#f8fc00"));
        radius+=5;
        g.fillOval(node.getX() - radius, node.getY() - radius, 2 * radius, 2 * radius);
        radius-=5;
    }

    public void drawSourceNode(Node node){
        g.setColor(parseColor("#ccd400"));
        g.fillOval(node.getX() - radius, node.getY() - radius, 2 * radius, 2 * radius);

        radius-=5;
        g.setColor(parseColor("#f1edb1"));
        g.fillOval(node.getX() - radius, node.getY() - radius, 2 * radius, 2 * radius);

        radius+=5;
        g.setColor(parseColor("#ccd400"));
        drawCentreText(String.valueOf(node.getId()), node.getX(), node.getY());
    }

    public void drawDestinationNode(Node node){
        g.setColor(parseColor("#F44336"));
        g.fillOval(node.getX() - radius, node.getY() - radius, 2 * radius, 2 * radius);

        radius-=5;
        g.setColor(parseColor("#e80606"));
        g.fillOval(node.getX() - radius, node.getY() - radius, 2 * radius, 2 * radius);

        radius+=5;
        g.setColor(parseColor("#F44336"));
        drawCentreText(String.valueOf(node.getId()), node.getX(), node.getY());
    }

    public void drawNode(Node node){
        g.setColor(parseColor("#e50606"));
        g.fillOval(node.getX() - radius, node.getY() - radius, 2 * radius, 2 * radius);

        radius-=5;
        g.setColor(parseColor("#c18d8d"));
        g.fillOval(node.getX() - radius, node.getY() - radius, 2 * radius, 2 * radius);

        radius+=5;
        g.setColor(parseColor("#b02626"));
        drawCentreText(String.valueOf(node.getId()), node.getX(), node.getY());
    }

    public void drawWeightText(String text, int x, int y) {
        g.setColor(parseColor("#cccccc"));
        FontMetrics fm = g.getFontMetrics();
        double t_width = fm.getStringBounds(text, g).getWidth();
        g.drawString(text, (int) (x - t_width / 2), (y + fm.getMaxAscent() / 2));
    }

    public void drawCentreText(String text, int x, int y) {
        FontMetrics fm = g.getFontMetrics();
        double t_width = fm.getStringBounds(text, g).getWidth();
        g.drawString(text, (int) (x - t_width / 2), (y + fm.getMaxAscent() / 2));
    }


    // Calculations
    private static int sqr(int x) {
        return x * x;
    }
    private static int dist2(Point v, Point w) {
        return sqr(v.x - w.x) + sqr(v.y - w.y);
    }
    private static int distToSegmentSquared(Point p, Point v, Point w) {
        double l2 = dist2(v, w);
        if (l2 == 0) return dist2(p, v);
        double t = ((p.x - v.x) * (w.x - v.x) + (p.y - v.y) * (w.y - v.y)) / l2;
        if (t < 0) return dist2(p, v);
        if (t > 1) return dist2(p, w);
        return dist2(p, new Point(
                (int)(v.x + t * (w.x - v.x)),
                (int)(v.y + t * (w.y - v.y))
        ));
    }
    private static int distToSegment(Point p, Point v, Point w) {
        return (int) Math.sqrt(distToSegmentSquared(p, v, w));
    }

}
