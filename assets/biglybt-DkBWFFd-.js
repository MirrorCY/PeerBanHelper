import"./index-CMI_Gzcy.js";import{f as b,a4 as g,ao as c,j as v,k as h,y as a,t,a2 as i,v as u,x as y,F as M}from"./libs-D5D6SZX3.js";import{s as S,F as U,R as w,r as x,V as R}from"./arcoDesign-C7uykCP7.js";const F=b({__name:"biglybt",props:{modelValue:{required:!0},modelModifiers:{}},emits:["update:modelValue"],setup(m){const{t:d}=g(),l=c(m,"modelValue"),f={type:"string",required:!0,validator:(n,e)=>{if(!n)return e("Please input URL");!n.startsWith("http://")&&!n.startsWith("https://")&&e(d("page.dashboard.editModal.label.endpoint.error.invalidSchema"));try{new URL(n),e()}catch{e(d("page.dashboard.editModal.label.endpoint.error.invalidUrl"))}}};return(n,e)=>{const s=S,r=U,p=w,_=x,V=R;return v(),h(M,null,[a(r,{field:"config.endpoint",label:i(d)("page.dashboard.editModal.label.endpoint"),"validate-trigger":"blur",required:"",rules:f},{default:t(()=>[a(s,{modelValue:l.value.endpoint,"onUpdate:modelValue":e[0]||(e[0]=o=>l.value.endpoint=o),"allow-clear":""},null,8,["modelValue"])]),_:1},8,["label"]),a(r,{field:"config.token",label:"Token",required:""},{default:t(()=>[a(s,{modelValue:l.value.token,"onUpdate:modelValue":e[1]||(e[1]=o=>l.value.token=o),"allow-clear":""},null,8,["modelValue"])]),_:1}),a(r,{field:"config.httpVersion",label:i(d)("page.dashboard.editModal.label.httpVersion")},{extra:t(()=>[u(y(i(d)("page.dashboard.editModal.label.httpVersion.description")),1)]),default:t(()=>[a(_,{modelValue:l.value.httpVersion,"onUpdate:modelValue":e[2]||(e[2]=o=>l.value.httpVersion=o)},{default:t(()=>[a(p,{value:"HTTP_1_1"},{default:t(()=>[u("1.1")]),_:1}),a(p,{value:"HTTP_2"},{default:t(()=>[u("2.0")]),_:1})]),_:1},8,["modelValue"])]),_:1},8,["label"]),a(r,{field:"config.verifySsl","default-checked":"",label:i(d)("page.dashboard.editModal.label.verifySsl")},{default:t(()=>[a(V,{modelValue:l.value.verifySsl,"onUpdate:modelValue":e[3]||(e[3]=o=>l.value.verifySsl=o)},null,8,["modelValue"])]),_:1},8,["label"])],64)}}});export{F as default};
