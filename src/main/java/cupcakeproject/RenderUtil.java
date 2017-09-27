/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupcakeproject;

import entities.Bottom;
import java.util.List;

/**
 *
 * @author lene_
 */
public class RenderUtil {
    
    public static String bottomTable(List<Bottom> bottoms){
        StringBuilder sb = new StringBuilder();
        sb.append("<table>\n"
                + "<tr><th>Navn</th><th>Pris</th></tr>\n");
        for(Bottom b : bottoms){
            sb.append("<tr>");
            sb.append("<td>").append(b.getType()).append("</td>");
            sb.append("<td>").append(b.getPrice()).append("</td>");
            sb.append("</tr>\n");
        }
        sb.append("</table>\n");
        return sb.toString();
    }
    
}
